/**
 * Created by Ognerezov on 07/12/16.
 */
var statlib={};

(function () {
    var arr=[];
    var sum=0;
    var avarage=0;
    statlib.add=function (num,isArray) {
        var n=num*1;
        if (!isNaN(n))arr.push(n);
        sum+=num;
        if (!isArray)
            recount();

    };
    function recount() {
        console.log(">>>Recount<<<");
        avarage=sum/arr.length;
        sort();
    }
    statlib.addAll=function (nums) {
        for(var i=0;i<nums.length;i++){
            statlib.add(nums[i],true);
        }
        recount();
    };
    statlib.avarage=function () {
        return avarage;
    }
    statlib.sko=function () {
        var res=0;
        for(var i=0;i<arr.length;i++){
            res+=(arr[i]-avarage)*(arr[i]-avarage);
        }
        return Math.sqrt(res);
    }

    statlib.array=function (a) {
        if(a==undefined) {
            var res=[];
            for (var i=0;i<arr.length;i++){
                res.push(arr[i]);
            }
            return res;
        }
        arr=[];
        for (var i=0;i<a.length;i++){
            arr.push(a[i]);
        }
    }

    statlib.intDevide=function (a,b) {
        return (a-a%b)/b;
    }
    statlib.av=function (a,b) {
        return (a+b)/2;
    }
    statlib.mediana=function () {
        if (arr.length<=1) return arr[0];
        var  middle=statlib.intDevide(arr.length,2);
        if (arr.length%2!=0) return arr[middle];
        if (arr.length==2) return avarage;
        return statlib.av( arr[middle],arr[middle+1]);
    }
    function sort() {
        arr.sort(function (a,b) {
            return a-b;
        })
    }


}());