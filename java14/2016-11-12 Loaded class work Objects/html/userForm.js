/**
 * Created by Ognerezov on 12/11/16.
 */
function User(l,p,fc) {
    var login=l;
    var password=p;
    var fcolor=fc;

    var getters ={
        login: function () {
            return login;
        },
        password: function () {
            return password;
        },
        fcolor: function () {
            return fcolor;
        }
    }

    var setters={
        login: function (val) {
            login=val;
            return "value changed";
        },
        password: function (val) {
           password=val;
            return "value changed";
        },
        fcolor: function (val) {
           fcolor=val;
            return "value changed";
        }
    }

    return {
        get: function (name) {
            if (typeof (name)!="string" ||name=="") return "incorrect name";
            return getters[name]();
        },

        set: function (name,val) {
            if (typeof (name)!="string" ||name=="") return "incorrect name";
            return setters[name](val);
        },

        toString: function () {
        return "User " + login+" has favorite color: " + fcolor +". ";
        }
    }
}

var users=[];

function createUser(u) {
    var login=u.get("login");
    var password=u.get("password");
    if (login==undefined || login==null||password==undefined ||password==null) return "Invalid login or password";
    for (var i=0;i<users.length;i++)
        if (login==users[i].get("login")) return "User already exists";
    users.push(u);
    return "Successfully created user: "+login;
}

function loginUser(login, password) {
    for (var i=0;i<users.length;i++){
        if (users[i].get("login")==login && users[i].get("password")==password) return users[i];
    }

    return "login failed";
}