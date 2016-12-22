/**
 * Created by Ognerezov on 20/12/2016.
 */
var mod=angular.module("invoice",[]);
mod.controller("invoiceCntr",["$scope","$http",function ($scope,$http) {
    $scope.prc=2.5;
    $scope.qty=1;
   $scope.cList=["USD","EUR","RUB","ILS"];
    $scope.cList={
        // "USD":1,
        // "EUR":0.94,
        // "CNY":6.8,
        // "ILS":3.85,
        // "RUB":65
    };
    var choice=["USD","EUR","RUB","ILS"];

    $http.get("http://api.fixer.io/latest")
        .then(function (res) {
            var rates=res.data.rates;
            rates[res.data.base]=1;
            $scope.curr=res.data.base;
            for(var i in choice){
                $scope.cList[choice[i]]=rates[choice[i]];
            }
        })

    $scope.curr="USD";
    $scope.total=function (x) {
       return $scope.qty*$scope.prc*
           $scope.cList[x]/$scope.cList[$scope.curr];
    }
}]);