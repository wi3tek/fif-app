'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'league.controllers', 'league.services', 'round.controllers', 'round.services', 'player.controllers', 'player.services', 'home.controllers', 'home.services']);

fifapp.config(function($routeProvider, $httpProvider) {
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
            templateUrl: '../../view/Player/view.html',
            url: '/players',
            controller: 'PlayerController'
        })
        .when('/register', {
            templateUrl: '../../view/Home/register.html',
            url: '/register',
            controller: 'HomeController'
        })
        .when('/login', {
            templateUrl: '../../view/Home/login.html',
            url: '/login',
            controller: 'HomeController'
        })

    .otherwise({
        templateUrl: '../../view/Home/view.html',
        url: '/home',
    })


});

