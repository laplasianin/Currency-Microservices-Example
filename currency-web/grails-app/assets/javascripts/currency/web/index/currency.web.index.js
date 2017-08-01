//= wrapped
//= require /angular/angular
//= require /angular/ui-bootstrap-tpls
//= require /angular/angular-ui-router
//= require chart.js/Chart
//= require angular-chart.js/angular-chart
//= require_self
//= require_tree services
//= require_tree controllers
//= require_tree directives
//= require_tree templates

angular.module("currency.web.index", [
    "currency.web.core",
    "ui.bootstrap",
    "ui.router",
    "chart.js"
])
.config(config);

function config($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('index', {
            url: "/",
            templateUrl: "/currency/web/index/index.html"
        });

    $urlRouterProvider.otherwise('/');
}
