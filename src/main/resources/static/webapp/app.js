'use strict'

var fifapp = angular.module('fifapp', ['ngRoute', 'ngResource', 'ngCookies', 'league.controllers', 'league.services', 'round.controllers', 'round.services', 'player.controllers', 'player.services', 'home.controllers', 'registration.services', 'login.controllers', 'logout.controllers', 'registration.controllers', 'login.services', 'admin.controllers', 'admin.services', 'user.controllers', 'user.services', 'alert.services', 'match.services']);

fifapp.config(function($routeProvider, $httpProvider) {
    $routeProvider

        .when('/leagues', {
            templateUrl: '/webapp/League/league.html',
            url: '/ligi',
            controller: 'LeagueController'
        })
        .when('/leagues/:leagueId', {
            url: '/liga/:leagueId',
            templateUrl: '/webapp/Round/round.html',
            controller: 'RoundController',
        })
        .when('/players', {
            templateUrl: '/webapp/Player/player.html',
            url: '/zawodnicy',
            controller: 'PlayerController'
        })
        .when('/registration', {
            templateUrl: '/webapp/Registration/registration.html',
            url: '/rejestracja',
            controller: 'RegistrationController'
        })
        .when('/login', {
            templateUrl: '/webapp/Login/login.html',
            url: '/zaloguj-sie',
            controller: 'LoginController'
        })
        .when('/logout', {
            templateUrl: '/webapp/Login/login.html',
            url: '/logout',
            controller: 'LogoutController'
        })
        .when('/regulations', {
            templateUrl: '/webapp/Home/regulations.html',
            url: 'zasady'
        })
        .when('/aboutUs', {
            templateUrl: '/webapp/Home/about.html',
            url: 'o-nas'
        })
        .when('/userDetails/:userLogin', {
            templateUrl: '/webapp/User/user.html',
            url: 'userData',
            controller: 'UserController'
        })
        .when('/controlPanel', {
            templateUrl: '/webapp/Admin/admin.html',
            url: 'controlPanel',
            controller: 'AdminController'
        })

    .otherwise({
        templateUrl: '/webapp/Home/home.html',
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
            $rootScope.authenticated = true;
            $rootScope.currentUser = $cookieStore.get('currentUser');
        }
    }
]);