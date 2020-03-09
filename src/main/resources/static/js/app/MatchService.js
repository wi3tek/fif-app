'use strict'

angular.module('match.services', []).service('MatchService', ["$http", function($http) {


    this.deleteMatch = function deleteMatch(matchId) {
        return $http({
            method: 'DELETE',
            url: 'matches/deleteMatch/',
            data: {
                matchId: matchId
            }
        });
    }

}])