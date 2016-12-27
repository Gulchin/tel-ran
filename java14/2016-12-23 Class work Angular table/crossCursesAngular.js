/**
 * Created by Ognerezov on 23/12/2016.
 */
angular.module("crossCourses",[]).controller("crossCoursesCntr",function ($scope,$interval,ratesService) {
    $scope.rates={};
    $interval(function () {
        ratesService().then(function (res) {
            $scope.rates = res;
        });
    },1000);
}).service("ratesService",function ($http) {
    var beloved=["USD","EUR","ILS","RUB","UAH","KZT"];
    var pairs=[];
    for (var i in beloved){
        for(var j in beloved) pairs.push(beloved[i]+beloved[j]);
    }
    var url='http://query.yahooapis.com/v1/public/yql?q=select * from ' +
        'yahoo.finance.xchange where pair in ("PAIRS")&format=json&' +
        'env=store://datatables.org/alltableswithkeys&callback=JSON_CALLBACK';
    var newUrl=url.replace("PAIRS",pairs.join());
    return function () {
      return  $http.jsonp(newUrl).then(function (res) {
            // var first=res.indexOf("(");
            var rate = res.data.query.results.rate;
            var arr = [];
            for (var i in rate) {
                arr[rate[i].id] = rate[i].Rate;
            }
            var result = {};
            for (var i in beloved) {
                result[beloved[i]] = [];
                for (var j in beloved) {
                    result[beloved[i]].push(arr[beloved[i] + beloved[j]]);
                }
            }
            return result;
        })
    }
})