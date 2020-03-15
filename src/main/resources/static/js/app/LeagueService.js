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

    this.updateLeague = function updateLeague(leagueId, name, startDate, endDate, description, location) {
        return $http({
            method: 'PUT',
            url: 'leagues/update',
            data: {
                leagueId: leagueId,
                name: name,
                description: description,
                startDate: startDate,
                endDate: endDate,
                location: location
            }
        })
    }

    this.deleteLeague = function deleteLeague(leagueId) {
        return $http({
            method: 'DELETE',
            url: 'leagues/delete/' + leagueId
        })
    }



}]);