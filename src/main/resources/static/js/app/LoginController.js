'use strict'

var fifapp = angular.module('login.controllers', []);

fifapp.controller('LoginController', ["$scope", '$rootScope',
    '$http', '$location', '$route', '$cookies',
    function($scope, $rootScope,
        $http, $location, $route) {

        $scope.alertMessage;
        $scope.alertStatus;
        $scope.alertPrefix;



        $scope.credentials = {};

        $scope.resetForm = function() {
            $scope.credentials = null
        }




        var authenticate = function(credentials, callback) {
            var headers = $scope.credentials ? {
                authorization: "Basic " +
                    btoa($scope.credentials.username + ":" +
                        $scope.credentials.password)
            } : {};
            $http.get('user', {
                headers: headers
            }).then(function(response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                    $rootScope.loggedUser = $scope.credentials.username;
                    console.log('poprawna autentykacja +\n response')
                    $scope.setAlert('Ppoprawna autentykacja', 1);
                } else {
                    $rootScope.authenticated = false;
                    console.log('nieudana autentykacja +\n response')
                    $scope.setAlert('nieudana autentykacja', 1);
                }
                callback && callback();
            }, function() {
                $rootScope.authenticated = false;
                callback && callback();
                console.log('autentykacja się nie udała\n' + callback)
                $scope.setAlert('autentykacja się nie udała', 1);
            });
        }
        authenticate();

        $scope.loginUser = function() {
            authenticate($scope.credentials, function(response) {
                if ($rootScope.authenticated) {
                    $location.path("/");
                    $scope.loginerror = false;
                    $scope.setAlert('Poprawnie zalogowano!', 1);
                } else {
                    $location.path("/login");
                    $scope.setAlert('Nie udało się zalogować. Spróbuj ponownie!', 0);
                    // $scope.loginerror = true;
                    console.log("coś poszło nie tak\nresponse:" + response)

                }


            })
        }

        $scope.setAlert = function(message, status) {
            $scope.alertStatus = status;
            if (status == 1) {
                $scope.alertPrefix = 'SUKCES! '
                $scope.alertMessage = message;
            } else {
                if (status == 0) {
                    $scope.alertPrefix = 'BŁĄD! '
                    $scope.alertMessage = message;
                } else {
                    $scope.alertPrefix = ''
                    $scope.alertMessage = message;
                }
            }

        }

        $(document).ready(function() {
            $("#eventAlert").hide();
            $(".alertAction").click(function showAlert() {
                $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                    $("#eventAlert").slideUp(500);
                });
            });
        });
    }
]);