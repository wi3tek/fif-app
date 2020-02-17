//'use strict'

var fifapp = angular.module('fifapp', ['ui.router', 'league.controllers', 'league.services']);

fifapp.constant("CONSTANTS", {
    getLeagueByIdUrl: "/leagues/getLeague",
    getAllLeagues: "/leagues/getAllLeagues",
    saveLeague: "/league/saveLeague"
});