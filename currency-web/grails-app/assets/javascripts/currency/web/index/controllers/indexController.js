//= wrapped

angular
    .module("currency.web.index")
    .controller("IndexController", IndexController)

function IndexController(applicationDataFactory, contextPath, $state, $scope, $window) {
    var vm = this;
    $scope.dataLoading = true

    applicationDataFactory.currency().then(function(response) {
        $scope.currency = response.data

        $scope.labels = $scope.currency.map(a => a.date)
        $scope.series = ['EUR', 'USD'];
        $scope.data = [
            $scope.currency.map(a => a.eur),
            $scope.currency.map(a => a.usd)
        ]

        $scope.dataLoading = false
    })

    function valueOnArrayFilter(value, type, arrayOperation) {
        var x = $scope.currency.map(a => a[type])
        return arrayOperation(...x) == value
    }

    $scope.isMin = function(value, type) {
        return valueOnArrayFilter(value, type, Math.min)
    }

    $scope.isMax = function(value, type) {
        return valueOnArrayFilter(value, type, Math.max)
    }
}