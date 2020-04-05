'use strict'

angular.module('match.services', []).service('MatchService', ["$http", function($http) {


    this.deleteMatch = function deleteMatch(matchId) {
        return $http({
            method: 'DELETE',
            url: 'matches/deleteMatch/',
            data: {
                matchId: matchId
            }
        });
    }

    this.addNewMatch = function addNewMatch(homeFirstPlayerId, homeSecondPlayerId,
        awayFirstPlayerId, awaySecondPlayerId, homeTeamId, awayTeamId, roundId, leagueId) {
        const myDate = new Date();
        const currentDate = new Date(myDate);
        currentDate.setHours(currentDate.getHours() + 1);

        return $http({
            method: 'POST',
            url: 'matches/addMatch',
            data: {
                matchDate: currentDate.toISOString(),
                homeFirstPlayerId: homeFirstPlayerId,
                homeSecondPlayerId: homeSecondPlayerId,
                awayFirstPlayerId: awayFirstPlayerId,
                awaySecondPlayerId: awaySecondPlayerId,
                homeGoals: 0,
                awayGoals: 0,
                homeTeamId: homeTeamId,
                awayTeamId: awayTeamId,
                comment: '',
                updateDate: currentDate.toISOString(),
                roundId: roundId,
                leagueId: leagueId
            }
        });
    }

}])