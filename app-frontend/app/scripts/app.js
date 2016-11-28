'use strict';

/**
 * @ngdoc overview
 * @name appFrontendApp
 * @description
 * # appFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('appFrontendApp', [
    'ui.router',
    'ngResource',
    'ngRoute',
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('portal', {
        url: '/',
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      });
    $urlRouterProvider.otherwise('/');
  });

