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
    $scope.sections = data.sections;
    $scope.setSection = function(section){
      if(section === null){ return; }
      data.setCurrentSection(section);
      $state.go('section', {id: section.section_id});
    };
  }]);
