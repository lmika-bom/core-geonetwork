(function() {
  goog.provide('gn_search');


  goog.require('gn_formatter_lib');
  goog.require('gn_map_field_directive');
  goog.require('gn_mdactions');
  goog.require('gn_mdview');
  goog.require('gn_module');
  goog.require('gn_resultsview');
  goog.require('gn_search_controller');
  goog.require('gn_viewer');
  goog.require('gn_openwis_subscription_module');

  var module = angular.module('gn_search', [
    'gn_module',
    'gn_resultsview',
    'gn_map_field_directive',
    'gn_search_controller',
    'gn_viewer',
    'gn_mdview',
    'gn_mdactions',
    'ui.bootstrap.buttons',
    'ui.bootstrap.tabs',
    'ngeo',
    'gn_openwis_subscription_module'
  ]);

  module.constant('gnSearchSettings', {});
  module.constant('gnViewerSettings', {});

  module.config(['$LOCALES', function($LOCALES) {
    $LOCALES.push('search');
  }]);

})();
