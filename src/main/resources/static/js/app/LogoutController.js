'use strict'

var fifapp = angular.module('logout.controllers', []);

fifapp.controller('LogoutController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'LoginService',
    function($scope, $rootScope,
        $http, $location, $route, LoginService) {

        $http.post('logout', {}).finally(function() {
            $rootScope.authenticated = false;
            $location.path("/login");
            $scope.setAlert('Poprawnie wylogowano!', 1);
            LoginService.ClearCredentials();
        });

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

    }
]);