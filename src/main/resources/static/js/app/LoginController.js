'use strict'

var fifapp = angular.module('login.controllers', []);

fifapp.controller('LoginController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'LoginService',
    function($scope, $rootScope,
        $http, $location, $route, LoginService) {

        // $rootScope.alertMessage;
        // $rootScope.alertStatus;
        // $rootScope.alertPrefix;

        $scope.setAlert = function(message, status) {
            $rootScope.alertStatus = status;
            if (status == 1) {
                $rootScope.alertPrefixZ = 'SUKCES! '
                $rootScope.alertMessageZ = message;
            } else {
                if (status == 0) {
                    $rootScope.alertPrefixZ = 'BŁĄD! '
                    $rootScope.alertMessageZ = message;
                } else {
                    $rootScope.alertPrefix = ''
                    $rootScope.alertMessageZ = message;
                }
            }
        }

        // $(document).ready(function() {
        //     $("#eventAlert").hide();
        //     $(".alertAction").click(function showAlert() {
        //         $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
        //             $("#eventAlert").slideUp(500);
        //         });
        //     });
        // });



        $scope.credentials = {};

        $scope.resetForm = function() {
            $scope.credentials = null
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
                    LoginService.SetCredentials($scope.credentials.username, $scope.credentials.password);
                    $scope.setAlert('Poprawnie zalogowano', 1);
                    $location.path("/");
                } else {
                    $location.path("/login");
                    $scope.setAlert('Niepoprawny login lub hasło! Spróbuj ponownie', 0);
                    console.log("coś poszło nie tak\nresponse:" + response)
                    $scope.dataLoading = false;
                }


            })
        }

    }
]);