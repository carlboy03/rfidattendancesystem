'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:SectionCtrl
 * @description
 * # SectionCtrl
 * Controller of the section state
 */
angular.module('appFrontendApp')
  .controller('SectionCtrl', ['$scope', 'data', '$state', function ($scope, data, $state) {
    $scope.currentSection = data.currentSection;
    $scope.selectedCourse = data.selectedCourse;
    $scope.selectedSection = data.selectedSection;
    $scope.date = new Date();
    $scope.getStudent = function(record){
      data.selectStudent(record.person);
      $state.go('student', {section_id: data.selectedSectionId(), id: record.person.person_id});
    };
  }]);
