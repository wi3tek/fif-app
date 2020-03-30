'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'ngResource', 'ngCookies', 'league.controllers', 'league.services', 'round.controllers', 'round.services', 'player.controllers', 'player.services', 'home.controllers', 'registration.services', 'login.controllers', 'logout.controllers', 'registration.controllers', 'login.services', 'admin.controllers', 'admin.services']);

fifapp.config(function($routeProvider, $httpProvider) {
    $routeProvider

        .when('/leagues', {
            templateUrl: '../../view/League/view.html',
            url: '/ligi',
            controller: 'LeagueController'
        })
        .when('/leagues/:leagueId', {
            url: '/liga/:leagueId',
            templateUrl: '../../view/Round/view.html',
            controller: 'RoundController',
        })
        .when('/players', {
            templateUrl: '../../view/Player/view.html',
            url: '/zawodnicy',
            controller: 'PlayerController'
        })
        .when('/registration', {
            templateUrl: '../../view/Home/registration.html',
            url: '/rejestracja',
            controller: 'RegistrationController'
        })
        .when('/login', {
            templateUrl: '../../view/Home/login.html',
            url: '/zaloguj-sie',
            controller: 'LoginController'
        })
        .when('/logout', {
            templateUrl: '../../view/Home/login.html',
            url: '/logout',
            controller: 'LogoutController'
        })
        .when('/regulations', {
            templateUrl: '../../view/Home/regulations.html',
            url: 'zasady'
        })
        .when('/aboutUs', {
            templateUrl: '../../view/Home/about.html',
            url: 'o-nas'
        })
        .when('/userDetails/:userLogin', {
            templateUrl: '../../view/User/view.html',
            url: 'userData'
        })
        .when('/controlPanel', {
            templateUrl: '../../view/Admin/view.html',
            url: 'controlPanel',
            controller: 'AdminController'
        })

    .otherwise({
        templateUrl: '../../view/Home/view.html',
        url: '/home',
        controller: 'HomeController'
    })


});

fifapp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);


fifapp.run(['$rootScope', '$location', '$cookieStore', '$http',
    function($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.loggedUser = $cookieStore.get('globals');
        if ($rootScope.loggedUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.loggedUser.authdata; // jshint ignore:line
        }
    }
]);