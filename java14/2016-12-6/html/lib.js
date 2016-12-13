/**
 * Created by Ognerezov on 06/12/16.
 */
var lib={};

+function () {
    lib.sin=function(x){return Math.sin(gradToRad(x))};
    var  rad=180/3.14158;
    function gradToRad(x) {
        return x/rad;
    }
}()
//Дз написать библиотеку
var triangle={};

(function () {
    triangle.geron=function (a,b,c) {
        return (a+b+c)/2
    }
}());