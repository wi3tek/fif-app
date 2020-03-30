'use strict'

var fifapp = angular.module('admin.controllers', []);

fifapp.controller('AdminController', ["$scope", '$rootScope',
    '$http', '$location', 'AdminService',
    function($scope, $rootScope,
        $http, $location, AdminService) {

        $scope.activeUserPanel;


        // if ($rootScope.authenticated != null) {
        //     $location.path("/login");
        //     $scope.loginerror = true;
        // }

        $scope.alertMessage;
        $scope.alertStatus;
        $scope.alertPrefix;

        $(document).ready(function() {
            $("#eventAlert").hide();
            $(".alertAction").click(function showAlert() {
                $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                    $("#eventAlert").slideUp(500);
                });
            });
        });



        $scope.setAlert = function(message, status) {
            $scope.alertStatus = status;
            if (status == 1) {
                $scope.alertPrefix = 'SUKCES! '
                $scope.alertMessage = message;
            } else {
                if (status == 0) {
                    $scope.alertPrefix = 'BŁĄD! '
                    $scope.alertMessage = message;
                } else {
                    $scope.alertPrefix = ''
                    $scope.alertMessage = message;
                }
            }

        }

        $scope.activate = function(user) {
            AdminService.activate(user)
                .then(function success(response) {
                    console.log("Poprawna aktywacja użytkownika\n" + response);
                    $scope.init();
                }, function errot(response) {
                    console.log("Błąd podczas aktywacji użytkownika\n" + response);
                })
        }

        $scope.desactivate = function(user) {
            AdminService.desactivate(user)
                .then(function success(response) {
                    console.log("Poprawna aktywacja użytkownika\n" + response);
                    $scope.init();
                }, function errot(response) {
                    console.log("Błąd podczas aktywacji użytkownika\n" + response);
                })
        }


        $scope.init = function() {
            AdminService.getAllUsers()
                .then(function success(response) {
                    $scope.users = response.data;
                    console.log('Pobrano użytkowników\n' + response)
                }, function error(response) {
                    console.log('Nie udało się pobrać użytkowników\n' + response)
                })
        }



        $(function() {
            var hash = window.location.hash;
            hash && $('ul.nav a[href="' + hash + '"]').tab('show');

            $('.nav-tabs a').click(function(e) {
                $(this).tab('show');
                var scrollmem = $('body').scrollTop();
                window.location.hash = this.hash;
                $('html,body').scrollTop(scrollmem);
            });
        });

        $scope.claculateTime = function(dt) {
            return new Date(dt).getTime();

        }

        $scope.setActiveUserPanel = function(user) {
            $scope.activeUserPanel = user;
        }

    }


]);