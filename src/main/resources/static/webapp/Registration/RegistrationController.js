'use strict'

var fifapp = angular.module('registration.controllers', []);

fifapp.controller('RegistrationController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'RegistrationService', 'AlertService',
    function($scope, $rootScope, $http, $location, $route, RegistrationService, AlertService) {
        $scope.newUser;

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



        if ($rootScope.authenticated) {
            $location.path("/");
        } else {
            $location.path("/registration");
        }

        $scope.registerUser = function() {
            if ($scope.newUser != null && $scope.newUser.username && $scope.newUser.password) {
                RegistrationService.createUser($scope.newUser.username, $scope.newUser.password, $scope.newUser.confirmPassword, $scope.newUser.email, $scope.newUser.confirmEmail,
                        $scope.newUser.reason)
                    .then(function success(response) {
                            AlertService.setAlert('Wysłano formularz do rejestracji - otrzymasz powiadomienie email', 1);
                            console.log($scope.alertMessage + '\n' + response)
                            $scope.resetForm();
                            $location.path('/home');
                        },
                        function error(response) {
                            if (response.status === 400) {
                                AlertService.setAlert('Błąd wprowadzonych danych - hasła i adresy email muszą być takie same', 0);
                            } else {
                                AlertService.setAlert('Błąd - nazwa użytkownika ustnieje', 0);
                            }
                            console.log($scope.alertMessage + '\n' + response)

                        });
            } else {
                AlertService.setAlert('Uzupełnij dane użytkownika', 0);
            }
        }


        $scope.resetForm = function() {
            $scope.newUser = null
        }

    }

]);