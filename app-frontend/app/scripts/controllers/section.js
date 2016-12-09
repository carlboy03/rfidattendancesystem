'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:SectionCtrl
 * @description
 * # SectionCtrl
 * Controller of the section state
 */
angular.module('appFrontendApp')
  .controller('SectionCtrl', ['$scope', 'data', 'auth', function ($scope, data, auth) {
    $scope.currentUser = auth.currentUser;
    $scope.currentSection = data.currentSection;
    $scope.selectedCourse = data.selectedCourse;
    $scope.selectedSection = data.selectedSection;
    $scope.date = new Date();
  }]);
