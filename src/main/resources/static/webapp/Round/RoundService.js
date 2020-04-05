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
            method: 'GET',
            url: 'matches/getLeagueMatches/' + leagueId,
        });
    };



    this.editMatch = function editMatch(matchId, matchDate, homeFirstPlayerId, homeSecondPlayerId, awayFirstPlayerId, awaySecondPlayerId,
        homeGoals, awayGoals, homeTeamId, awayTeamId, comment, roundId, leagueId) {

        const myDate = new Date();
        const currentDate = new Date(myDate);
        currentDate.setHours(currentDate.getHours() + 1);
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
                updateDate: currentDate.toISOString(),
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

    this.getTeamsByRound = function getTeamsByRound(roundId) {
        return $http({
            method: 'GET',
            url: 'teams/initTeamsList/' + roundId
        })
    }

    this.deleteMatch = function deleteMatch(matchId) {
        return $http({
            method: 'DELETE',
            url: 'matches/deleteMatch/' + matchId,
        });
    }

    this.deleteRound = function deleteRound(roundId) {
        return $http({
            method: 'DELETE',
            url: 'rounds/deleteRound/' + roundId,
        });
    }

    this.addRound = function addRound(whichLeagueRound, leagueId, description) {
        const myDate = new Date();
        const currentDate = new Date(myDate);
        currentDate.setHours(currentDate.getHours() + 1);

        return $http({
            method: 'POST',
            url: 'rounds/addRound',
            data: {
                roundDate: currentDate.toISOString(),
                whichLeagueRound: whichLeagueRound + 1,
                description: description,
                matchDtos: [],
                teamDtos: [],
                leagueId: leagueId
            }
        });
    }

    this.getLeagueTable = function getLeagueTable(leagueId) {
        return $http({
            method: 'GET',
            url: 'leagues/getLeagueTable/' + leagueId
        })
    }



}])