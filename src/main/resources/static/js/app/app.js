//'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'league.controllers', 'league.services', 'round.controllers', 'round.services']);

fifapp.config(function($routeProvider) {
    $routeProvider

        .when('/leagues', {
            templateUrl: '../../view/League/view.html',
            controller: 'LeagueController'
        })
        .when('/leagues/:leagueId', {
            url: '/leagues/:leagueId',
            templateUrl: '../../view/Round/view.html',
            controller: 'RoundController',
        })

    .otherwise({
        redirectTo: '/'
    })


});

fifapp.constant("CONSTANTS", {
    getLeagueByIdUrl: "/leagues/getLeague",
    getAllLeagues: "/leagues/getAllLeagues",
    saveLeague: "/league/saveLeague"
});