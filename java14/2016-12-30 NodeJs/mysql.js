/**
 * Created by Ognerezov on 03/01/2017.
 */
var mysql = require('mysql');
module.exports = mysql.createConnection({
    host : "localhost",
    user : "root",
    password : "1234",
    database : "test"
});