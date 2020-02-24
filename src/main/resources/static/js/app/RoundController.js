'use strict'

var fifapp = angular.module('round.controllers', []);

fifapp.controller('RoundController', ["$scope", 'RoundService', '$routeParams', function($scope, RoundService, $routeParams) {

    $scope.getLeague = function() {
        $scope.leagueId = $routeParams.leagueId;
        var id = $scope.leagueId;
        RoundService.getLeague($scope.leagueId)
            .then(function success(response) {
                    $scope.league = response.data;
                    $scope.league.id = id;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    if (response.status === 404) {
                        $scope.errorMessage = 'League not found';
                    } else {
                        $scope.errorMessage = "Error getting league";
                    }
                })
    }

}])