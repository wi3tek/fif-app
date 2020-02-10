'use strict'

var fifApp = angular.module('fifapp', ['league.controllers', 'league.services']);

fifApp.constant("CONSTANTS", {
    getLeagueByIdUrl: "/leagues/getLeague",
    getAllLeagues: "/leagues/getAllLeagues",
    saveLeague: "league/saveLeague"
});