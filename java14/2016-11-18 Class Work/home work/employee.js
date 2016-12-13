/**
 * Created by Ognerezov on 18/11/16.
 */
function Employee(n,a,m,s) {
    this.name=n||"Ivanov";
    this.age=a||99;
    this.married=m||true;
    this.salary=s||9999;
}

function comparatorEmployee(str) {
    var res={
        "name":function (e1,e2) {return e1.name.localeCompare(e2.name);},
        "age": function (e1,e2) {return e1.age-e2.age;},
        "married": function (e1,e2) {return e1.married==e2.married ? 0:(e1.married ? -1:1)},
        "salary": function (e1,e2) {return e1.salary-e2.salary;}
        };
    return res[str];

}