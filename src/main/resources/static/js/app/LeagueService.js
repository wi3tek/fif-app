//'use strict'

angular.module('league.services', []).factory('LeagueService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = [];
    service.getAllLeagues = function() {
        //return $http.get(CONSTANTS.getAllLeagues);

        return $http({
            method: 'GET',
            url: 'leagues/getAllLeagues'
        }).then(function successCallback(response) {
            $scope.service = response.data.service;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
    return service;
}]);