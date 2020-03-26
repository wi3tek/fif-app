'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", 'HomeService', '$window', function($scope, HomeService, $window) {
    $scope.alertMessage;
    $scope.alertStatus;
    $scope.alertPrefix;

    $scope.userCredentials;
    $scope.newUser;
    $scope.loginForm;

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

    $scope.resetRegistrationForm = function() {
        $scope.newUser = {};
    }

    $scope.resetLoginForm = function() {
        $scope.userCredentials = {};
    }



    $scope.registerPlayer = function() {
        if ($scope.newUser != null && $scope.newUser.username && $scope.newUser.password) {
            HomeService.createUser($scope.newUser.username, $scope.newUser.password, $scope.newUser.email,
                    $scope.newUser.reason)
                .then(function success(response) {
                        $scope.setAlert('Wysłano formularz do rejestracji', 1);
                        console.log($scope.alertMessage + '\n' + response)
                        $scope.resetRegistrationForm();
                        $window.location.href = '../../view/Home/login.html';
                    },
                    function error(response) {
                        $scope.setAlert('Błąd podczas rejestracji użytkownika', 0);
                        console.log($scope.alertMessage + '\n' + response)

                    });
        } else {
            $scope.setAlert('Uzupełnij dane użytkownika', 0);
        }
    }

}]);