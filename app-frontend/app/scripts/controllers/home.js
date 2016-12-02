'use strict';

/**
 * @ngdoc function
 * @name appFrontendApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the home state
 */
angular.module('appFrontendApp')
  .controller('HomeCtrl', ['$scope', 'data', '$state', function ($scope, data, $state) {
    $scope.user = data.user;
    $scope.sections = data.sections;
    $scope.setSection = function(section){
      if(section === null){ return; }
      data.setCurrentSection(section);
      $state.go('section', {id: section.section_id});
    };
  }]);
