'use strict'

angular.module('registration.services', []).service('RegistrationService', ["$http", function($http) {

    this.createUser = function createUser(username, password, email, registrationReason) {
        return $http({
            method: 'POST',
            url: '/register',
            data: {
                username: username,
                email: email,
                password: password,
                registrationReason: registrationReason
            }
        });
    }

    this.updateUser = function updateUser(userId, username, password, email, registrationReason) {
        return $http({
            method: 'PUT',
            url: '/updateUser',
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
            url: 'active/update',
            data: {
                userId: userId,
                active: true
            }
        })
    }


    this.desactivate = function activate(userId) {
        return $http({
            method: 'PUT',
            url: 'active/update',
            data: {
                userId: userId,
                active: false
            }
        })
    }



    this.deleteUser = function deleteUser(userId) {
        return $http({
            method: 'DELETE',
            url: 'user/delete/' + userId
        })
    }

}]);