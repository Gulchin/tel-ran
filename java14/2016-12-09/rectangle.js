/**
 * Created by Ognerezov on 09/12/16.
 */
function Rectangle(aa,bb) {
    // var a=aa;
    // var b=bb;
    // return{
    //     getA :function () {
    //         return a;
    //     },
    //     getB :function () {
    //         return b;
    //     },
    //     setA : function (x) {
    //         a=x;
    //     },
    //     setB : function (x) {
    //         b=x;
    //     }
    // };
    var sides={
        a :aa,
        b :bb
    }

    return{
        side: function (name,value) {
            if (value==undefined){
                return sides[name];
            } else {
                sides[name]=value;
            }
        }
    }
}