/**
 * Created by Michael on 11/3/2016.
 */
function Person(n,a,m){

    var name = n;
    var age = a;
    var married = m;

    function getN(){return name;}
    function getA(){return age;}
    function getM(){return married;}

    function setN(n){name = n;}

    return {
        getName : getN,
        getAge  : getA,
        getMarried : getM,
        setName : setN
    }
}