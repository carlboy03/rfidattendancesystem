'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the appFrontendApp
 */
angular.module('appFrontendApp')
  .controller('MainCtrl' ,function ( $scope, $http, $log ) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.rfid=[];
    $http.get('/app-backend/count').success(function(data){
      $scope.rfid=data;

    });
    $log.error($scope);


  });
