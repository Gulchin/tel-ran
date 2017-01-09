/**
 * Created by Ognerezov on 30/12/2016.
 */
angular.module("auth",[])
    .controller("authCntr",function($scope,$http){

        $scope.submit = function(){
            var obj = {};
            obj.login = $scope.login;
            obj.psw = $scope.psw;

            $http.post("localhost:8081/auth",obj)
                .then(function (res) {
                    console.log(res);
                });
        }

    })