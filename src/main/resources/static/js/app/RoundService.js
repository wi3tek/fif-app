'use strict'

angular.module('round.services', []).service('RoundService', ["$http", function($http) {
    this.getLeague = function getLeague(leagueId) {
        return $http({
            method: 'GET',
            url: 'leagues/getLeague/' + leagueId
        });
    };

    this.getLeagueRounds = function getLeagueRounds(leagueId) {
        return $http({
            method: 'GET',
            url: 'rounds/getLeagueRounds/' + leagueId
        });
    };


    this.getRoundMatches = function getRoundMatches(roundId) {
        return $http({
            method: 'GET',
            url: 'matches/getRoundMatches/' + roundId
        });
    };


    this.getLeagueMatches = function getLeagueMatches(leagueId) {
        return $http({
            method: 'PUT',
            url: 'matches/getLeagueMatches/' + leagueId,
        });
    };



    this.editMatch = function editMatch(matchId, matchDate, homeFirstPlayerId, homeSecondPlayerId, awayFirstPlayerId, awaySecondPlayerId,
        homeGoals, awayGoals, homeTeamId, awayTeamId, comment, updateDate, roundId, leagueId) {
        return $http({
            method: 'PUT',
            url: 'matches/updateMatch',
            data: {
                matchId: matchId,
                matchDate: matchDate,
                homeFirstPlayerId: homeFirstPlayerId,
                homeSecondPlayerId: homeSecondPlayerId,
                awayFirstPlayerId: awayFirstPlayerId,
                awaySecondPlayerId: awaySecondPlayerId,
                homeGoals: homeGoals,
                awayGoals: awayGoals,
                homeTeamId: homeTeamId,
                awayTeamId: awayTeamId,
                comment: comment,
                updateDate: updateDate,
                roundId: roundId,
                leagueId: leagueId
            }
        });
    };


    this.getAllPlayers = function getAllPlayers() {
        return $http({
            method: 'GET',
            url: 'players/getAll'
        });
    }

    this.getTeams = function getTeams() {
        return $http({
            method: 'GET',
            url: 'teams/getAllTeams'
        });
    }



}])