'use strict'

var fifapp = angular.module('player.controllers', []);

fifapp.controller('PlayerController', ["$scope", 'PlayerService', function($scope, PlayerService) {
    $scope.playerEdited;
    $scope.newPlayer;
    $scope.activePlayer;
    $scope.errorMessage;
    $scope.message;

    $scope.addPlayer = function() {
        if ($scope.player != null && $scope.player.name && $scope.player.alias) {
            PlayerService.addPlayer($scope.player.name, $scope.player.alias, $scope.player.dateOfBirth, $scope.player.userId)
                .then(function success(response) {
                        $scope.message = 'Poprawnie dodano ligę';
                        $scope.errorMessage = '';
                        $scope.resetPlayerForm();
                        $scope.init();
                    },
                    function error(response) {
                        $scope.errorMessage = 'Błąd podczas dodawania ligi';
                        $scope.message = '';

                    });
        } else {
            $scope.errorMessage = 'Uzupełnij dane';
            $scope.message = '';
        }
    }

    $scope.editPlayer = function() {
        if ($scope.player != null && $scope.player.name && $scope.player.alias) {
            PlayerService.editPlayer($scope.player.playerId, $scope.player.name, $scope.player.alias, $scope.player.dateOfBirth,
                    $scope.player.joinDate, $scope.player.userId)
                .then(function success(response) {
                        $scope.message = 'Poprawnie dodano ligę';
                        $scope.errorMessage = '';
                        $scope.getPlayers();
                        $scope.resetPlayerForm();
                    },
                    function error(response) {
                        $scope.errorMessage = 'Błąd podczas dodawania ligi';
                        $scope.message = '';

                    });
        } else {
            $scope.errorMessage = 'Uzupełnij dane';
            $scope.message = '';
        }
    }


    $scope.getPlayers = function() {
        PlayerService.getPlayers()
            .then(function success(response) {
                    $scope.players = response.data;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Błąd podczas dodawania gracza!';
                });
    }

    $scope.resetPlayerForm = function() {
        $scope.player = {};
        $scope.playerForm.$setPristine();
    }

    $scope.init = function() {
        $scope.getPlayers();
    }

    $scope.deletePlayer = function() {
        if ($scope.playerEdited != null) {
            PlayerService.deleteMatch($scope.playerEdited.playerId)
                .then(function success() {
                        $scope.message = 'Poprawnie usunięto gracza';
                        $scope.errorMessage = '';
                        $scope.init();
                    },
                    function error() {
                        $scope.errorMessage = 'Błąd podczas usuwania gracza';
                        $scope.message = '';
                    });

        } else {
            $scope.errorMessage = 'Błąd danych';
            $scope.message = '';
        }
    }

    $scope.setActivePlayer = function(player) {
        $scope.activePlayer = player;
    }

    $scope.calculateAge = function() { // birthday is a date
        var _birthDay = new Date($scope.activePlayer.dateOfBirth)
        var ageDifMs = Date.now() - _birthDay.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    $scope.claculateTime = function(dt) {
        return new Date(dt).getTime();

    }

    $scope.setPlayerEdited = function(data) {
        $scope.playerEdited = data;
    }
}]);