/**
 * Created by Ognerezov on 06/12/16.
 */
window.addEventListener("load",function () {


    var inp = document.getElementById("inp");
    var sp = document.getElementById("sp");
    inp.onkeyup = function () {
        sp.innerText = inp.value;
    }

    (function () {
        console.log("***");
    }());
})