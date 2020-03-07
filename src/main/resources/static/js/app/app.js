'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'league.controllers', 'league.services', 'round.controllers', 'round.services', 'player.controllers', 'player.services']);

fifapp.config(function($routeProvider) {
    $routeProvider

        .when('/leagues', {
            templateUrl: '../../view/League/view.html',
            url: '/leagues',
            controller: 'LeagueController'
        })
        .when('/leagues/:leagueId', {
            url: '/leagues/:leagueId',
            templateUrl: '../../view/Round/view.html',
            controller: 'RoundController',
        })
        .when('/players', {
            templateUrl: '../view/Players/view.html',
            url: '/players',
            controller: 'PlayerController'
        })

    .otherwise({
        templateUrl: '../../view/Home/view.html',
        url: '/home',
    })


});


fifapp.constant("CONSTANTS", {
    getLeagueByIdUrl: "/leagues/getLeague",
    getAllLeagues: "/leagues/getAllLeagues",
    saveLeague: "/league/saveLeague"
});