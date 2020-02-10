'use strict'

var module = angular.module('league.controllers', []);

module.controller("LeagueController", ["$scope", "LeagueService",
    function($scope, LeagueService) {

        $scope.getListOfLeagues = function() {
            LeagueService.getAllLeagues().then(function(value) {
                $scope.allLeagues = value.data;
            });
        }
    }
])