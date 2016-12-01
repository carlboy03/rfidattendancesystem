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
      {
        attendance_id: 3,
        attendance_status: false,
        person: {
          person_id: 4,
          person_name: 'Jose',
          person_last_name: 'Lugo',
          person_type: 1,
          person_uprm_id: '802091535',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 4,
        attendance_status: true,
        person: {
          person_id: 5,
          person_name: 'Carlos',
          person_last_name: 'Bernal',
          person_type: 1,
          person_uprm_id: '802071244',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 5,
        attendance_status: true,
        person: {
          person_id: 6,
          person_name: 'Maria',
          person_last_name: 'Jimenez',
          person_type: 1,
          person_uprm_id: '802084234',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 6,
        attendance_status: false,
        person: {
          person_id: 7,
          person_name: 'Michael',
          person_last_name: 'Mercado',
          person_type: 1,
          person_uprm_id: '844091435',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 7,
        attendance_status: true,
        person: {
          person_id: 8,
          person_name: 'Joe',
          person_last_name: 'Lopez',
          person_type: 1,
          person_uprm_id: '802091234',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 8,
        attendance_status: true,
        person: {
          person_id: 9,
          person_name: 'Edgar',
          person_last_name: 'Fuentes',
          person_type: 1,
          person_uprm_id: '802081234',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 9,
        attendance_status: false,
        person: {
          person_id: 10,
          person_name: 'Jose',
          person_last_name: 'Rivera',
          person_type: 1,
          person_uprm_id: '802091535',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 10,
        attendance_status: true,
        person: {
          person_id: 11,
          person_name: 'Ricky',
          person_last_name: 'Soto',
          person_type: 1,
          person_uprm_id: '802071244',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 11,
        attendance_status: true,
        person: {
          person_id: 12,
          person_name: 'Lola',
          person_last_name: 'Velez',
          person_type: 1,
          person_uprm_id: '801084534',
          person_rfid_id: 'changeme'
        }
      },
      {
        attendance_id: 12,
        attendance_status: false,
        person: {
          person_id: 13,
          person_name: 'Lolo',
          person_last_name: 'Lugo',
          person_type: 1,
          person_uprm_id: '844093456',
          person_rfid_id: 'changeme'
        }
      }
    ];
    return data;
  }]);

