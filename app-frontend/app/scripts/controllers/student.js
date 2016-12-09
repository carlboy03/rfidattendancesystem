'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:StudentCtrl
 * @description
 * # StudentCtrl
 * Controller of the student state
 */
angular.module('appFrontendApp')
  .controller('StudentCtrl', ['$scope', 'data', function ($scope, data) {
    $scope.currentSection = data.currentSection;
    $scope.currentStudent = data.currentStudent;
    $scope.selectedCourse = data.selectedCourse;
    $scope.selectedSection = data.selectedSection;
    $scope.selectedStudent = data.selectedStudent;
  }]);
