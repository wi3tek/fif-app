//'use strict'

//var module = angular.module('league.controllers', []);
var fifapp = angular.module('league.controllers', []);

fifapp.controller('LeagueController', ["$scope", "$http", getListOfLeagues]);


function getListOfLeagues($scope, $http) {
    $scope.leagues = [];
    $http({
        method: 'GET',
        url: 'leagues/getAllLeagues'
    }).then(function successCallback(response) {
        $scope.leagues = response.data;
    }, function errorCallback(response) {
        console.log(response.statusText);
    });

}