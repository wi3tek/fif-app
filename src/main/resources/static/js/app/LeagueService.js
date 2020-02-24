'use strict'

angular.module('league.services', []).service('LeagueService', ["$http", function($http) {

    this.getAllLeagues = function getAllLeagues() {
        return $http({
            method: 'GET',
            url: 'leagues/getAllLeagues'
        });
    }

    this.addLeague = function addLeague(name, startDate, endDate, description, location) {
        return $http({
            method: 'POST',
            url: 'leagues/saveLeague',
            data: {
                name: name,
                description: description,
                startDate: startDate,
                endDate: endDate,
                location: location
            }
        });
    }
}]);