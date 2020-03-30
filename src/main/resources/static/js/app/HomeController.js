'use strict'

var fifapp = angular.module('home.controllers', []);

fifapp.controller('HomeController', ["$scope", '$window', '$rootScope', '$http', '$location', '$route', 'LeagueService', function($scope, $window, $rootScope,
    $http, $location, $route, LeagueService) {

    $scope.userCredentials;


    // if ($rootScope.authenticated) {
    //     $location.path("/home");
    //     $scope.loginerror = false;
    // } else {
    //     $location.path("/home");
    //     $scope.loginerror = true;
    // }


    $(document).ready(function() {
        $("#eventAlert").hide();
        $(".alertAction").click(function showAlert() {
            $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                $("#eventAlert").slideUp(500);
            });
        });
    });

    // $scope.setAlert = function(message, status) {
    //     $rootScope.alertStatus = status;
    //     if (status == 1) {
    //         $rootScope.alertPrefixZ = 'SUKCES! '
    //         $rootScope.alertPrefixZ = message;
    //     } else {
    //         if (status == 0) {
    //             $rootScope.alertPrefix = 'BŁĄD! '
    //             $rootScope.alertPrefixZ = message;
    //         } else {
    //             $rootScope.alertPrefixZ = ''
    //             $rootScope.alertPrefixZ = message;
    //         }
    //     }

    // }
}]);