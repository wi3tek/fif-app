'use strict'

var fifapp = angular.module('user.controllers', []);

fifapp.controller('UserController', ["$scope", 'UserService', function($scope, UserService) {

    $scope.getUserByUsername = function(username) {
        UserService.getUserByUsername(username)
            .then(function success(response) {
                    $rootScope.currentUser = response.data;
                    console.log('Success getting ' + username)
                },
                function error(response) {
                    console.log('error getting user ' + username)
                    if (response.status === 404) {
                        console.log('User not found ' + username);
                    } else {
                        console.log('Error getting user ' + username);
                    }

                })
    }

}]);