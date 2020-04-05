'use strict'

var fifapp = angular.module('admin.controllers', []);

fifapp.controller('AdminController', ["$scope", '$rootScope', '$location', 'AdminService', 'AlertService',

    function($scope, $rootScope, $location, AdminService, AlertService) {

        $scope.activeUserPanel;


        if ($rootScope.authenticated && !$rootScope.currentUser.admin) {
            AlertService.setAlert('Nie masz dostępu do tego zasobu!', 0);
            $location.path('/home')
        }


        $(document).ready(function() {
            $("#eventAlert").hide();
            $(".alertAction").click(function showAlert() {
                $("#eventAlert").fadeTo(3500, 500).slideUp(500, function() {
                    $("#eventAlert").slideUp(500);
                });
            });
        });

        $scope.activate = function(id) {
            AdminService.activate(id)
                .then(function success(response) {
                    AlertService.setAlert('Poprawna aktywacja użytkownika!', 1)
                    console.log("Poprawna aktywacja użytkownika");
                    $scope.activeUserPanel = null;
                    $scope.init();
                }, function errot(response) {
                    AlertService.setAlert('Błąd podczas aktywacji użytkownika!', 0)
                    console.log("Błąd podczas aktywacji użytkownika\n" + response);
                })
        }

        $scope.deactivate = function(id) {
            AdminService.deactivate(id)
                .then(function success(response) {
                    AlertService.setAlert('Poprawna dezaktywacja użytkownika!', 1)
                    console.log("Poprawna aktywacja użytkownika\n" + response);
                    $scope.activeUserPanel = null;
                    $scope.init();
                }, function errot(response) {
                    AlertService.setAlert('Błąd podczas dezaktywacji użytkownika!', 0)
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