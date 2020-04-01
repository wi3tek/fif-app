'use strict'

angular.module('registration.services', []).service('RegistrationService', ["$http", function($http) {

    this.createUser = function createUser(username, password, confirmPassword, email, confirmEmail, registrationReason) {
        return $http({
            method: 'POST',
            url: '/usersControls/register',
            data: {
                username: username,
                email: email,
                confirmEmail: confirmEmail,
                password: password,
                confirmPassword: confirmPassword,
                registrationReason: registrationReason

            }
        });
    }

}]);