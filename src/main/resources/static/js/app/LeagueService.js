'use strict'

angular.module('league.services', []).factory('LeagueService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getAllLeagues = function() {
        return $http.get(CONSTANTS.getAllLeagues);
    }

}]);