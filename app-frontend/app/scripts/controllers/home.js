'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the home state
 */
angular.module('appFrontendApp')
  .controller('HomeCtrl', ['$scope', 'data', 'auth', '$state', function ($scope, data, auth, $state) {
    $scope.currentUser = auth.currentUser;
    $scope.currentSections = data.currentSections;
    $scope.getSection = function(item){
      data.selectCourse(item.course);
      data.selectSection(item.section);
      data.selectSectionId(item.section);
      $state.go('section', {id: item.section.section_id});
    };
  }]);
