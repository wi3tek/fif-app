'use strict'

var fifapp = angular.module('logout.controllers', []);

fifapp.controller('LogoutController', ["$scope", '$rootScope',
    '$http', '$location', '$route', 'LoginService', 'AlertService',
    function($scope, $rootScope,
        $http, $location, $route, LoginService, AlertService) {

        if ($rootScope.authenticated) {
            LoginService.Logout()
                .then(function success(response) {
                    AlertService.setAlert('Poprawnie wylogowano!', 1);
                    console.log('Poprawnewylogowanie')
                    LoginService.ClearCredentials();
                    $location.path("/home");
                }, function error(response) {
                    AlertService.setAlert('Błąd podczas wylogowania!', 0);
                    console.log('Błąd podczas wylogowania: ' + response)
                })
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