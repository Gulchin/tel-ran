/**
 * Created by Ognerezov on 03/01/2017.
 */
angular.module("hny",[]).controller("hnyCntr",function ($scope) {
    $scope.key=false;
    $scope.push=function () {
        $scope.key=true;
    }
}).directive("mary",function () {
    return function ($scope,elem) {
        $scope.$watch("key",function () {
            if($scope.key){
                elem.append(angular.element("<span> Happy new year!</span>"));
            }
        })
    }
})