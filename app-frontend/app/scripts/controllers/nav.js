'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:NavCtrl
 * @description
 * # NavCtrl
 * Controller of the navbar
 */
angular.module('appFrontendApp')
  .controller('NavCtrl', ['$scope', 'auth', function ($scope, auth) {
    $scope.currentUser = auth.currentUser;
    $scope.isLoggedIn = auth.isLoggedIn;
  }]);
