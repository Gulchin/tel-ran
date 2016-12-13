/**
 * Created by Michael on 11/10/2016.
 */
function Book(t,a,y){

    var title = t;
    var author = a;
    var year = y;

    var g = {
        title : function(){return title;},
        author : function(){return author;},
        year : function(){return year;}
    }

    var s = {
        title : function(val){title = val; return "OK";},
        author : function(val){author = val; return "OK";},
        year : function(val){if(val < 1600) return "wrong value"; year = val; return "OK";}
    }

    return {
        value: function (name, val) {
            if (name == undefined)return undefined;
            if (typeof(name) != "string") return "name isn't string";
            if (name == "")return "name is empty";
            if (val == undefined) {
                if (g[name] == undefined) return "no such property";
                return g[name]();
            }
            else{
                if (s[name] == undefined) return "no such property";
                return s[name](val);
            }
        },

        toString : function(){return "Title : "+title+"; Author : "+author+ "; "+"; Year : "+ year;}


    }
}