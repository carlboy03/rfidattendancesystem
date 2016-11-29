'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the home state
 */
angular.module('appFrontendApp')
  .controller('HomeCtrl', ['$scope', 'data', function ($scope, data) {
    $scope.user = data.user;
    $scope.sections = data.sections;
  }]);
