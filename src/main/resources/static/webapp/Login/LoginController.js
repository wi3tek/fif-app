'use strict'

var fifapp = angular.module('login.controllers', []);

fifapp.controller('LoginController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'LoginService', 'UserService', 'AlertService', '$cookieStore',
    function($scope, $rootScope,
        $http, $location, $route, LoginService, UserService, AlertService, $cookieStore) {


        if ($rootScope.authenticated) {
            $location.path("/home");
            $scope.loginerror = true;
        }

        $(document).ready(function() {
            $("#eventAlert").hide();
            $(".alertAction").click(function showAlert() {
                $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                    $("#eventAlert").slideUp(500);
                });
            });
        });



        $scope.credentials = {};

        $scope.resetForm = function() {
            $scope.credentials = {}
        }


        // var authenticate = function(credentials, callback) {
        //     var headers = $scope.credentials ? {
        //         authorization: "Basic " +
        //             btoa($scope.credentials.username + ":" +
        //                 $scope.credentials.password)
        //     } : {};
        //     $http.get('user', {
        //         headers: headers
        //     }).then(function(response) {
        //         if (response.data.name) {
        //             $rootScope.authenticated = true;
        //             console.log('poprawna autentykacja +\n response')
        //             $scope.setAlert('Ppoprawna autentykacja', 1);
        //         } else {
        //             $rootScope.authenticated = false;
        //             console.log('Użytkownik nie został aktywowany')
        //             $scope.setAlert('Użytkownik nie został aktywowany', 0);
        //         }
        //         callback && callback();
        //     }, function() {
        //         $scope.setAlert('Niepoprawny login lub hasło! Spróbuj ponownie', 0);
        //         $rootScope.authenticated = false;
        //         callback && callback();
        //         console.log('Błędne logowanie')
        //     });
        // }


        //authenticate();

        $scope.loginUser = function() {
            $scope.dataLoading = true;
            // authenticate($scope.credentials, function(response) {
            LoginService.Login($scope.credentials, function(response) {
                if ($rootScope.authenticated) {
                    LoginService.SetCredentials($scope.credentials.username, $scope.credentials.password)
                    UserService.getUserByUsername($rootScope.loggedUser.username)
                        .then(function success(response) {
                                AlertService.setAlert('Poprawnie zalogowano!', 1);
                                $rootScope.currentUser = response.data;
                                $cookieStore.put('currentUser', $rootScope.currentUser);
                                console.log('Success setting current user ')
                                $location.path("/");
                                console.log('Poprawne zalogowanie');
                            },
                            function error(response) {
                                console.log('error getting user ')
                                if (response.status === 404) {
                                    console.log('User not found ');
                                } else {
                                    console.log('Error getting user ');
                                }

                            })
                } else {
                    $location.path("/login");
                    console.log("Błąd podczas logowania:\n" + response)
                    AlertService.setAlert('Niepoprawny login lub hasło! Spróbuj ponownie', 0);
                    $scope.dataLoading = false;
                }


            })
        }

    }
]);