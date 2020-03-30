'use strict'

angular.module('admin.services', []).service('AdminService', ["$http", function($http) {

    this.getAllUsers = function getAllUsers() {
        return $http({
            method: 'GET',
            url: 'getAllUsers'
        })
    }

    this.updateUser = function updateUser(userId, username, password, email, registrationReason) {
        return $http({
            method: 'PUT',
            url: 'updateUser',
            data: {
                userId: userId,
                username: username,
                email: email,
                password: password,
                registrationReason: registrationReason
            }
        });
    }

    this.activate = function activate(user) {
        return $http({
            method: 'PUT',
            url: 'activate',
            data: user
        })
    }

    this.desactivate = function activate(user) {
        return $http({
            method: 'PUT',
            url: 'desactivate',
            data: user
        })
    }
}]);