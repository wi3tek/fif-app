'use strict'

angular.module('player.services', []).service('PlayerService', ["$http", function($http) {

    this.getPlayers = function getPlayers() {
        return $http({
            method: 'GET',
            url: 'players/getAll'
        });
    }

    this.addPlayer = function addPlayer(name, alias, dateOfBirth, joinDate, userId) {
        const myDate = new Date();
        const currentDate = new Date(myDate);
        currentDate.setHours(currentDate.getHours() + 1);
        return $http({
            method: 'POST',
            url: 'players/create',
            data: {
                name: name,
                alias: alias,
                dateOfBirth: dateOfBirth,
                joinDate: currentDate.toISOString(),
                lastModificationDate: currentDate.toISOString(),
                userId: userId,
            }
        });
    }

    this.updatePlayer = function updatePlayer(playerId, name, alias, dateOfBirth, joinDate, userId) {
        const myDate = new Date();
        const currentDate = new Date(myDate);
        currentDate.setHours(currentDate.getHours() + 1);
        return $http({
            method: 'PUT',
            url: 'players/update',
            data: {
                playerId: playerId,
                name: name,
                alias: alias,
                dateOfBirth: dateOfBirth,
                joinDate: joinDate,
                lastModificationDate: currentDate.toISOString(),
                userId: userId,
            }
        })
    }

    this.deletePlayer = function deletePlayer() {
        return $http({
            method: 'DELETE',
            url: 'players/delete/' + playerId
        })
    }

}]);