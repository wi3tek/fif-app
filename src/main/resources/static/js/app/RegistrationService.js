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

}]);