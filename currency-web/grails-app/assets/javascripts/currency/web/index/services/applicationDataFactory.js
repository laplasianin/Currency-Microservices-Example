//= wrapped

angular
    .module("currency.web.index")
    .factory("applicationDataFactory", applicationDataFactory);

function applicationDataFactory($http) {
    return {
        get: function() {
            return $http({method: "GET", url: "application"});
        },
        currency: function() {
            return $http({method: "GET", url: "http://localhost:8899/currency-back/currency"});
        }
    }
}