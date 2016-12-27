/**
 * Created by Ognerezov on 20/12/2016.
 */
var mod=angular.module("invoice",["api"]).controller("invoiceCntr",function ($scope,ratesService) {
    $scope.prc=2.5;
    $scope.qty=1;


     $scope.cList={};
     $scope.curr;

    ratesService.then(function (res) {
        $scope.curr=res.curr;
        $scope.cList=res.cList;
    })

    $scope.curr="USD";
    $scope.total=function (x) {
       return $scope.qty*$scope.prc*
           $scope.cList[x]/$scope.cList[$scope.curr];
    }
});
