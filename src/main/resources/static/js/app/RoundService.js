//'use strict'

angular.module('round.services', []).service('RoundService', ["$http", function($http) {
    this.getLeague = function getLeague(leagueId) {
        return $http({
            method: 'GET',
            url: 'leagues/getLeague/' + leagueId
        });
    }
}])