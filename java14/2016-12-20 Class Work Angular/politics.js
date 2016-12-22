/**
 * Created by Ognerezov on 20/12/2016.
 */
function Politic(name,country,age) {
    this.name=name;
    this.country=country;
    this.age=age;
}

var politics=[];

politics.push(new Politic("Netanjahu","Israel",67));
politics.push(new Politic("Trump","USA",70));
politics.push(new Politic("Putin","Russia",64));
politics.push(new Politic("Xi Zhing Pin","China",57));
politics.push(new Politic("Merkel","Germany",16));
politics.push(new Politic("Poroshenko","Ukraine",51));

angular.module("politics",[])
.controller("politicsContr",["$scope", function ($scope) {
    $scope.partners=politics;
    $scope.fields =["Name","Country","Age"];
}])