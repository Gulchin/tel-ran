/**
 * Created by Ognerezov on 27/12/2016.
 */
var pConfig={
    masha:"blue.html",
    sasha: "green.html",
    vasya: "red.html"
}

angular.module("opa",[])
    .controller("opaCntr",function ($scope) {
        $scope.page="red.html";
        $scope.show=function (color) {$scope.page=color+".html";}
    })