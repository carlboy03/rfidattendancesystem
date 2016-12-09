'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:NavCtrl
 * @description
 * # NavCtrl
 * Controller of the navbar
 */
angular.module('appFrontendApp')
  .controller('NavCtrl', ['$scope', 'auth', '$state', function ($scope, auth, $state) {
    $scope.currentUser = auth.currentUser;
    $scope.isLoggedIn = auth.isLoggedIn;
    $scope.logout = function(){
      auth.logout();
      $state.go('portal');
    };
  }]);
