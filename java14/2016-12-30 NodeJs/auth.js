/**
 * Created by Ognerezov on 30/12/2016.
 */
// var http=require("http");
// var express=require("express");
// var app=express();
// // var headers=require("headers");
// http.createServer(app).listen(8081);
// console.log("server on 8081 is on");
// app.post("/auth",function (req,res) {
//     // headers.setHeaders(res);
//     res.setHeader("Access-Control-Allow-Origin","*");
//     res.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS, PUT, PATCH, DELETE");
//     res.setHeader("Access-Control-Allow-Headers","X-Requested-With, content-type");
//     res.setHeader("Access-Control-Allow-Credentials", true);
//     var post="";
//     req.on("data",function (chunk) {
//         post+=chunk.toString();
//     })
//     req.on("end",function () {
//         console.log(post);
//     })
//     res.write("ok");
//     res.end();
// });

var http = require('http');
var express = require('express');
var app = express();
var headers = require('./headersdef');

http.createServer(app).listen(8081);
console.log("Server at 8081 is ON");

app.use("/*",function(req,res,next){
    headers.setHeaders(res);
    // res.setHeader("Access-Control-Allow-Origin","*");
    // res.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS, PUT, PATCH, DELETE");
    // res.setHeader("Access-Control-Allow-Headers","X-Requested-With, content-type");
    // res.setHeader("Access-Control-Allow-Credentials", true);
    next();
})
var mysql = require('./mysql');
app.post("/auth",function(req,res){

    var post = "";
    req.on("data",function(chunk){post=post+chunk.toString()});
    req.on("end",function(){
        console.log(post);
        res.write("OK");
        res.end();
    })
})



