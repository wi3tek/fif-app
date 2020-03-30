var fifapp = angular.module('login.services', []);

fifapp.factory('LoginService', ['$http', '$cookieStore', '$rootScope', '$timeout', function($http, $cookieStore, $rootScope, $timeout) {
    var service = {};

    service.SetCredentials = function(username, password) {
        var auth = btoa(username + ':' + password);

        $rootScope.loggedUser = {
            username: username,
            authdata: auth
        };

        $http.defaults.headers.common['Authorization'] = 'Basic ' + auth;
        $cookieStore.put('globals', $rootScope.loggedUser);
    };


    service.ClearCredentials = function() {
        $rootScope.loggedUser = {};
        $cookieStore.remove('globals');
        $http.defaults.headers.common.Authorization = 'Basic ';
    };


    service.Login = function(credentials, callback) {

        /* Dummy authentication for testing, uses $timeout to simulate api call
         ----------------------------------------------*/
        $timeout(function() {

            var headers = credentials ? {
                authorization: "Basic " +
                    btoa(credentials.username + ":" +
                        credentials.password)
            } : {};
            $http.get('user', {
                headers: headers
            }).then(function(response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                    console.log('poprawna autentykacja +\n response')
                } else {
                    $rootScope.authenticated = false;
                    console.log('Użytkownik nie został aktywowany')
                }
                callback && callback();
            }, function() {
                $rootScope.authenticated = false;
                callback && callback();
                console.log('Błędne logowanie')
            });
        }, 1000);


        /* Use this for real authentication
         ----------------------------------------------*/
        //$http.post('/api/authenticate', { email: email, password: password })
        //    .success(function (response) {
        //        callback(response);
        //    });

    };

    return service;

}]);