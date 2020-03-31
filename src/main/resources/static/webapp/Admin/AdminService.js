'use strict'

angular.module('admin.services', []).service('AdminService', ["$http", function($http) {

    this.getAllUsers = function getAllUsers() {
        return $http({
            method: 'GET',
            url: '/usersControls/getAllUsers'
        })
    }

    this.updateUser = function updateUser(userId, username, password, email, registrationReason) {
        return $http({
            method: 'PUT',
            url: '/usersControls/updateUser',
            data: {
                userId: userId,
                username: username,
                email: email,
                password: password,
                registrationReason: registrationReason
            }
        });
    }

    this.activate = function activate(userId) {
        return $http({
            method: 'PUT',
            url: '/usersControls/activate/' + userId
        })
    }

    this.deactivate = function deactivate(userId) {
        return $http({
            method: 'PUT',
            url: '/usersControls/deactivate/' + userId
        })
    }
}]);