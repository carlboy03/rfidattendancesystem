'use strict';

/**
 * @ngdoc overview
 * @name appFrontendApp
 * @description
 * # appFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('appFrontendApp', [
    'ui.router',
    'ngResource',
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('portal', {
        url: '/',
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .state('home', {
        url: '/home',
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl'
      })
      .state('section', {
        url: '/section/:id',
        templateUrl: 'views/section.html',
        controller: 'SectionCtrl',
      })
      .state('about', {
        url: '/about',
        templateUrl: 'views/about.html',
      });
    $urlRouterProvider.otherwise('/');
  })
  .factory('data', ['$http', function($http){
    var data = {};
    data.setCurrentSection = function(section){
      data.currentSection = section;
    };
    data.hasSelectedSection = function(){
      if(data.currentSection == null)
        return false;
      else
        return true;
    };
    data.isLoggedIn = function(){
      if(data.user == null){
        return false;
      }
      else
        return true;
    }
    data.user = {
      person_id: 1,
      person_name: 'Manuel',
      person_last_name: 'Rodriguez',
      person_type: 0,
      person_uprm_id: '802864000',
      person_rfid_id: 'changeme',
    };
    data.sections = [
      {
        section_id: 1,
        section_name: '020',
        section_term: 1,
        course: {
          course_id: 1,
          course_code: 'ICOM5007',
          course_name: 'Operative Systems',
        },
      },
      {
        section_id: 2,
        section_name: '030',
        section_term: 1,
        course: {
          course_id: 2,
          course_code: 'ICOM5016',
          course_name: 'Database Systems',
        },
      }
    ];
    data.records = [
      {
        attendance_id: 1,
        attendance_status: true,
        person: {
          person_id: 2,
          person_name: 'Jan',
          person_last_name: 'Vega',
          person_type: 1,
          person_uprm_id: '802091234',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 2,
        attendance_status: true,
        person: {
          person_id: 3,
          person_name: 'Carlos',
          person_last_name: 'Fuentes',
          person_type: 1,
          person_uprm_id: '802081234',
          person_rfid_id: 'changeme'
        }
      },
    ];
    return data;
  }]);

