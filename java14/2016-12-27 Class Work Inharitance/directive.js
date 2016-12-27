/**
 * Created by Ognerezov on 27/12/2016.
 */
var victorina={
    meal:{
        question: "What is you favorite meal?",
        answers: ["borsh","olivje","shak shuka"]
    },
    wife:{
        question: "What is you favorite wife?",
        answers: ["Sarah","Rachel","I have only 1 wife"]
    },

    pet:{
        question: "What is you favorite game?",
        answers: ["FootBall","BasketBall","Stick throwing"]
    }
};
angular.module("quest",[]).controller("questCntr",function ($scope) {
    $scope.key="meal";
    $scope.push=function (str) {
        $scope.key=str;
        console.log($scope.key);
    }
})
    .directive("question",function () {
        return function ($scope,elem) {
            $scope.$watch("key", function () {

                elem.empty();
                var p = angular.element("<p>");
                var q = victorina[$scope.key].question;
                var sel = angular.element("<select>");
                var answers = victorina[$scope.key].answers;
                for (var i in answers) {
                    var opt = angular.element("<option>");
                    opt.text(answers[i]);
                    sel.append(opt)
                }
                p.text(q);
                elem.append(p);
                elem.append(sel);
            })
        }
    })