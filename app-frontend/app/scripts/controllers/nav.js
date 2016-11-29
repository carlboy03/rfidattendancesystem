'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:NavCtrl
 * @description
 * # NavCtrl
 * Controller of the navbar
 */
angular.module('appFrontendApp')
  .controller('NavCtrl', ['$scope', 'data', function ($scope, data) {
    $scope.user = data.user;
    $scope.isLoggedIn = data.isLoggedIn;
  }]);
