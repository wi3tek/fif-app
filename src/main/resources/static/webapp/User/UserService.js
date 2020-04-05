'use strict'

angular.module('user.services', []).service('UserService', ["$http", function($http) {

    this.getUserByUsername = function getUserByUsername(username) {
        return $http({
            method: 'GET',
            url: 'usersControls/getUser/' + username
        });
    }
}]);