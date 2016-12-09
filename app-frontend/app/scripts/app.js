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
        url: '/home/:id',
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl',
        resolve: {
          sectionPromise: ['data', '$stateParams', function(data, $stateParams){
            return data.getSections($stateParams.id)
          }]
        }
      })
      .state('section', {
        url: '/section/:id',
        templateUrl: 'views/section.html',
        controller: 'SectionCtrl',
        resolve: {
          attendancePromise: ['data', '$stateParams', function(data, $stateParams){
            return data.getSection($stateParams.id);
          }]
        }
      })
      .state('student', {
        url: '/section/:section_id/student/:id',
        templateUrl: 'views/student.html',
        controller: 'StudentCtrl',
        resolve: {
          studentPromise: ['data', '$stateParams', function(data, $stateParams){
            return data.getStudent($stateParams.section_id, $stateParams.id);
          }]
        }
      })
      .state('about', {
        url: '/about',
        templateUrl: 'views/about.html',
      });
    $urlRouterProvider.otherwise('/');
  })
  .factory('data', ['$http', function($http){
    var data = {};
    // State methods
    data.selectCourse = function(course){
      localStorage.setObject('course_code', course.course_code);
    };
    data.selectedCourse = function(){
      return localStorage.getObject('course_code');
    };
    data.selectSection = function(section){
      localStorage.setObject('section_name', section.section_name);
    };
    data.selectedSection = function(){
      return localStorage.getObject('section_name');
    };
    data.selectSectionId = function(section){
      localStorage.setObject('section_id', section.section_id);
    };
    data.selectedSectionId = function(){
      return localStorage.getObject('section_id');
    };
    data.selectStudent = function(student){
      localStorage.setObject('student', student);
    };
    data.selectedStudent = function(){
      return localStorage.getObject('student');
    };
    // Home View
    data.getSections = function(id){
      return $http.get('/app-backend/section/'+id).success(function(sections){
        data.sections = sections;
      });
    };
    data.hasCurrentSections = function(){
      if(!data.sections){
        return false;
      }
      else {
        return true;
      }
    };
    data.currentSections = function(){
      if(data.hasCurrentSections()){
        return data.sections;
      }
      return null;
    };
    // Attendance View
    data.getSection = function(id){
      return $http.get('/app-backend/attendance/'+id).success(function(section){
        data.section = section;
      });
    };
    data.hasCurrentSection = function(){
      if(!data.section){
        return false;
      }
      else {
        return true;
      }
    };
    data.currentSection = function(){
      if(data.hasCurrentSection()){
        return data.section;
      }
      return null;
    };
    // Student View
    data.getStudent = function(section_id, id){
      return $http.get('/app-backend/attendance/'+section_id+'/student/'+id).success(function(student){
        console.log(student);
        data.student = student;
      });
    };
    data.hasCurrentStudent = function(){
      if(!data.student){
        return false;
      }
      else {
        return true;
      }
    };
    data.currentStudent = function(){
      if(data.hasCurrentStudent()){
        return data.student;
      }
      return null;
    };
    return data;
  }])
  .factory('auth', ['$http', function($http){
    var auth = {};
    auth.currentUser = function(){
      if(auth.isLoggedIn()){
        return localStorage.getObject('user');
      }
      return null;
    };
    auth.isLoggedIn = function(){
      if(!localStorage.getObject('user')){
        return false;
      }
      else {
        return true;
      }
    };
    auth.login = function(user){
      return $http.post('/app-backend/login', user).success(function(data){
        auth.user = data;
        localStorage.setObject('user', data);
      });
    };
    return auth;
  }]);

Storage.prototype.setObject = function(key, value) {
  this.setItem(key, JSON.stringify(value));
};

Storage.prototype.getObject = function(key) {
  var value = this.getItem(key);
  return value && JSON.parse(value);
};
