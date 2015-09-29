(function() {
  goog.provide('gn_openwis_blacklist_controller');

  var module = angular.module('gn_openwis_blacklist_controller', []);

  module.controller('GnOpenwisBlacklistController', [
      '$scope',
      '$routeParams',
      '$http',
      '$rootScope',
      function($scope, $routeParams, $http, $rootScope) {

        $scope.data = [];
        $scope.numResults = 20;

        $scope.updateData = function() {

          // TODO paginate
          $http.get(
              $scope.url + 'openwis.blacklisting.search?startWith='
                  + $scope.username + '&maxResults=' + $scope.numResults)
              .success(function(data) {
                $scope.data = data;
              }).error(function(data) {
                $rootScope.$broadcast('StatusUpdated', {
                  title : 'Error',
                  msg : 'Error getting user details. Please reload.',
                  type : 'danger'
                });
              });
        };

        $scope.updateData();

        $("#editBlackList").modal();
        $("#editBlackList").modal('hide');

        $scope.edit = function(element) {
          $scope.element = element;
          $http({
            url : $scope.url + 'openwis.blacklisting.isBlacklisted',
            method : 'POST',
            params : $scope.element
          }).success(function(data) {
            $scope.element.isBlacklisted = data;
            $("#editBlackList").modal();
          }).error(function(data) {
            console.log(data);
            $scope.updateData();
            $rootScope.$broadcast('StatusUpdated', {
              title : 'Error',
              msg : 'Error getting user details. Please reload.',
              type : 'danger'
            });
          });
        };
      }
  ]);

  module.controller('GnOpenwisBlacklistModalController', function($scope,
      $http, $rootScope) {
    $scope.ok = function() {
      $http({
        url : $scope.url + 'openwis.blacklisting.set',
        method : 'POST',
        params : $scope.element
      }).success(function(data) {
        $scope.updateData();
        $("#editBlackList").modal('hide');
      }).error(function(data) {
        console.log(data);
        $scope.updateData();
        $rootScope.$broadcast('StatusUpdated', {
          title : 'Error',
          msg : 'Error saving user details. Please try again.',
          type : 'danger'
        });
      });
    };

    $scope.cancel = function() {
      $("#editBlackList").modal('hide');
    };
  });

})();
