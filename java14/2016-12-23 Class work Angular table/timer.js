/**
 * Created by Ognerezov on 23/12/2016.
 */

var mod=angular.module("timer",[]);
mod.controller("timerCntr",function ($scope,$interval,getDate) {
    $scope.t=new Date();
    $interval(function () {
        $scope.t=getDate();
    },1000)

});
mod.service("getDate",function () {
    return function () {
       return new Date();
    }
})