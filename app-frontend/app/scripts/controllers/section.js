'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:SectionCtrl
 * @description
 * # SectionCtrl
 * Controller of the section state
 */
angular.module('appFrontendApp')
  .controller('SectionCtrl', ['$scope', 'data', function ($scope, data) {
    $scope.user = data.user;
    $scope.selectedSection = data.currentSection;
    $scope.records = data.records;
    $scope.date = new Date();
  }]);
