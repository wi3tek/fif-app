'use strict'

angular.module('player.services', []).service('PlayerService', ["$http", function($http) {

    this.getPlayers = function getPlayers() {
        return $http({
            method: 'GET',
            url: 'players/getAll'
        });
    }

    this.addPlayer = function addPlayer(name, alias, dateOfBirth, ownerId) {
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
                ownerId: ownerId,
            }
        });
    }

    this.updatePlayer = function updatePlayer(playerId, name, alias, dateOfBirth, joinDate, ownerId) {
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
                ownerId: ownerId,
            }
        })
    }

    this.deletePlayer = function deletePlayer(playerId) {
        return $http({
            method: 'DELETE',
            url: 'players/delete/' + playerId
        })
    }

    this.getPlayersMatchesInLeague = function getPlayersMatchesInLeague(leagueId) {
        return $http({
            method: 'GET',
            url: 'players/matchesInLeague/' + leagueId
        })
    }

}]);