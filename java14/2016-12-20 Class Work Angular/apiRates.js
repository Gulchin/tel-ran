/**
 * Created by Ognerezov on 23/12/2016.
 */
var mod=angular.module("api",[]).service("ratesService",function ($http) {
    var choice=["USD","EUR","RUB","ILS"];

    var cList={};
    return $http.get("http://api.fixer.io/latest")
        .then(function (res) {
            var rates=res.data.rates;
            rates[res.data.base]=1;
            var curr=res.data.base;
            for(var i in choice){
                cList[choice[i]]=rates[choice[i]];
            }
            return {
                curr: curr,
                cList: cList
            }
        })

});