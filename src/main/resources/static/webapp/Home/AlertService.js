'use strict'

angular.module('alert.services', []).service('AlertService', ['$rootScope', function($rootScope) {

    this.setAlert = function setAlert(message, status) {
        $rootScope.alertStatus = status;
        if (status == 1) {
            $rootScope.alertPrefix = 'SUKCES! '
            $rootScope.alertMessage = message;
        } else {
            if (status == 0) {
                $rootScope.alertPrefix = 'BŁĄD! '
                $rootScope.alertMessage = message;
            } else {
                $rootScope.alertPrefix = ''
                $rootScope.alertMessage = message;
            }
        }
    }
}]);