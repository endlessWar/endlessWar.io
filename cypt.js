import apiconfig from '../config.js';
import md5 from 'js-md5'
import { AES, enc } from 'crypto-js'
var crypt_api = {};

crypt_api.genToken=function (txt) {
    //时间限制，暂时无用
    // let d= new Date();
    // d.add("s",10);
    // let strTime=d.Format("yyyy-MM-dd hh:mm:ss");
    // let token = txt;
    let enCodetoken = this.enCode(txt);
    return enCodetoken;
};
crypt_api.genTokenByKey=function (txt,key) {

    let enCodetoken = this.enCodeByKey(txt,key);
    return enCodetoken;
};
crypt_api.md5=function (txt) {
    return md5(txt);
};
crypt_api.enCode=function (token) {
    let ciphertext = AES.encrypt(token, global.cryptKey);
    return ciphertext.toString();
};
crypt_api.enCodeByKey=function (token,key) {
    let ciphertext = AES.encrypt(token, key);
    return ciphertext.toString();
};
crypt_api.deCode=function (txt) {
    var bytes  = AES.decrypt(txt, global.cryptKey);
    var plaintext = bytes.toString(enc.Utf8);
    return plaintext;
};
crypt_api.isPasstime=function(tm)
{
    let dt = tm.convertDateFromString(tm);
    if(new Date()<dt)
        return false
    else
        return true;
}




/**
 *js中更改日期
 * y年， m月， d日， h小时， n分钟，s秒
 */
Date.prototype.add = function (part, value) {
    value *= 1;
    if (isNaN(value)) {
        value = 0;
    }
    switch (part) {
        case "y":
            this.setFullYear(this.getFullYear() + value);
            break;
        case "m":
            this.setMonth(this.getMonth() + value);
            break;
        case "d":
            this.setDate(this.getDate() + value);
            break;
        case "h":
            this.setHours(this.getHours() + value);
            break;
        case "n":
            this.setMinutes(this.getMinutes() + value);
            break;
        case "s":
            this.setSeconds(this.getSeconds() + value);
            break;
        default:

    }
};
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o){
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};


String.prototype.convertDateFromString= function(dateString) {
    if (dateString) {
        var arr1 = dateString.split(" ");
        var sdate = arr1[0].split('-');
        var hms=arr1[1].split(":");
        var date = new Date(sdate[0], sdate[1]-1, sdate[2]);
        date.setHours(hms[0],hms[1],hms[2]);
        return date;
    }
}

export  default crypt_api;