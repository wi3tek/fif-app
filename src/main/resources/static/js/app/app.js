'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'ngResource', 'ngCookies', 'league.controllers', 'league.services', 'round.controllers', 'round.services', 'player.controllers', 'player.services', 'home.controllers', 'registration.services', 'auth.factory', 'login.controllers', 'logout.controllers', 'registration.controllers']);

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
        .when('/registration', {
            templateUrl: '../../view/Home/registration.html',
            url: '/registration',
            controller: 'RegistrationController'
        })
        .when('/login', {
            templateUrl: '../../view/Home/login.html',
            url: '/login',
            controller: 'LoginController'
        })
        .when('/logout', {
            templateUrl: '../../view/Home/login.html',
            url: '/logout',
            controller: 'LogoutController'
        })
        .when('regulations', {
            templateUrl: '../../view/Home/regulations.html',
            url: 'regulations'
        })
        .when('/aboutUs', {
            templateUrl: '../../view/Home/about.html',
            url: 'aboutUs'
        })
        .when('/userDetails/:userLogin', {
            templateUrl: '../../view/User/view.html',
            url: 'userData'
        })

    .otherwise({
        templateUrl: '../../view/Home/view.html',
        url: '/home',
    })


});

fifapp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);