
define(["angular","jquery","ngRoute","text!templates/home.html"],function(angular,$,ngRoute,HomeTemp){

    console.log("fdsfdfds");
    var helloAngularApp = angular.module("helloCompojureApp",["ngRoute"])
                          .controller("home",function($scope,$http){
                              $scope.message = "Hello Compojure from Angular World ";
                              $scope.getDataMessage = "";
                              $scope.postDataMessage = "";
                              $scope.getData = function(){
                                  $http({
                                      url: "http://localhost:3000/maninder",
                                      method: "GET"
                                  }).then(function(data){
                                        $scope.getDataMessage = data.data.message;
                                  },function(error){
                                      console.log("dsfdsfdsf");
                                  });
                              };
                              $scope.postData = function(){
                                  $http({
                                      url: "http://localhost:3000/post",
                                      method: "POST",
                                      data: {"name" : "maninder"}
                                  }).then(function(data){
                                      $scope.postDataMessage = data.data.message.name;
                                  },function(error){
                                      console.log("dsfdsfdsf");
                                  });
                              };
                          })
                          .config(['$routeProvider',function ($routeProvider) {
                              $routeProvider.
                              when('/', {
                                      template: HomeTemp,
                                      controller: 'home'
                                  })
                                  .otherwise({redirectTo: '/'});
                          }]);

    helloAngularApp.init = function () {
        angular.bootstrap($("#helloCompojureApp"),['helloCompojureApp']);
    };
    return helloAngularApp;
});