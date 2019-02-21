import apiconfig from '../config.js';
import zygl_api from "./zygl_api";

let sjjh_api = {};
let sjjhurl = global.OperaLogUrl;
//带页数获取列表
sjjh_api.getPage = function(Url,form,data){
    return this.post(Url + "/show",form,data);
};
//获取全部数据
sjjh_api.getAll = function(Url,form,data){
    return this.post(Url+"/list",form,data);
};
//添加一行数据
sjjh_api.addOne = function(Url,form,data){
    return this.post(Url+"/add",form,data)
}
//获取某行数据的信息
sjjh_api.getById = function(Url,guid,form,data){
    return this.post(Url+"/get/"+guid,form,data);
}
//更新某行数据的信息
sjjh_api.update = function(Url,form,data){
    return this.post(Url+"/update",form,data);
};
//删除某行数据的信息（只有ApiInfo可以用）
sjjh_api.del = function(Url,guid,form,data){
    return this.post(Url+"/del/"+guid,form,data);
};
//获取数据交换页面数据
sjjh_api.getMessage = function(form,data){
    return this.post(sjjhurl+"/getToShowSjjh",form,data);
};
//根据guid查询微服务listData
sjjh_api.getBySystem=function (Url,guid,form) {
    return this.post(Url+"/getBySystem/"+guid,form,{});
};
//根据guid查询模块moduleData
sjjh_api.getByMirco=function (Url,guid,form) {
    return this.post(Url+"/getByMirco/"+guid,form,{});
};
//获取接口日志
sjjh_api.getLog=function(form,data){
    return this.post(sjjhurl+"/jkkbShow",form,data);

};
//调用get方法
sjjh_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
sjjh_api.post = function (Url, form, data) {
    return form.axios.post(Url, data);
};

export default sjjh_api;
