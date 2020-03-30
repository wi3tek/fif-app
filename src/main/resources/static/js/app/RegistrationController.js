'use strict'

var fifapp = angular.module('registration.controllers', []);

fifapp.controller('RegistrationController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'RegistrationService',
    function($scope, $rootScope, $http, $location, $route, RegistrationService) {
        $scope.newUser;

        $scope.alertMessage;
        $scope.alertStatus;
        $scope.alertPrefix;

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



        if ($rootScope.authenticated) {
            $location.path("/");
        } else {
            $location.path("/registration");
        }

        $scope.registerUser = function() {
            if ($scope.newUser != null && $scope.newUser.username && $scope.newUser.password) {
                RegistrationService.createUser($scope.newUser.username, $scope.newUser.password, $scope.newUser.email,
                        $scope.newUser.reason)
                    .then(function success(response) {
                            $scope.setAlert('Wysłano formularz do rejestracji - otrzymasz powiadomienie email', 1);
                            console.log($scope.alertMessage + '\n' + response)
                            $scope.resetForm();
                            $location.path('/home');
                        },
                        function error(response) {
                            $scope.setAlert('Błąd podczas rejestracji użytkownika', 0);
                            console.log($scope.alertMessage + '\n' + response)

                        });
            } else {
                $scope.setAlert('Uzupełnij dane użytkownika', 0);
            }
        }


        $scope.resetForm = function() {
            $scope.newUser = null
        }



    }
]);