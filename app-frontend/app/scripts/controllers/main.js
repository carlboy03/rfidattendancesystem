'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the appFrontendApp
 */
angular.module('appFrontendApp')
  .controller('MainCtrl', ['auth', '$scope', '$state', function (auth, $scope, $state) {
    $scope.user = {};
    $scope.login = function(){
      if($scope.user.email === null || $scope.user.password === null){ return; }
      auth.login($scope.user).success(function(){
        $scope.user = {};
        $state.go('home');
      });
    };
  }]);
