import sjjh_api from "./sjjh_api";

let ApiInfo_api = {};
let url = global.ApiInfo;
//带页数获取列表
ApiInfo_api.getPage = function(form,data){
    return this.post(url + "/show",form,data);
};
//获取全部数据
ApiInfo_api.getAll = function(form,data){
    return this.post(url+"/list",form,data);
};
//添加一行数据
ApiInfo_api.addOne = function(form,data){
    return this.post(url+"/add",form,data)
};
//获取某行数据的信息
ApiInfo_api.getById = function(guid,form,data){
    return this.post(url+"/get/"+guid,form,data);
};
//通过提供商获取对应接口的信息
ApiInfo_api.getByPro = function(guid,form,data){
    return this.post(url+"/getByPro/"+guid,form,data);
};
//更新某行数据的信息
ApiInfo_api.update = function(form,data){
    return this.post(url+"/update",form,data);
};
//删除某行数据的信息（只有ApiInfo可以用）
ApiInfo_api.del = function(guid,form,data){
    return this.post(url+"/del/"+guid,form,data);
};
//调用get方法
ApiInfo_api.get = function (Url,form) {
    return form.axios.get(Url);
};

//调用post方法
ApiInfo_api.post = function (Url, form, data) {
    return form.axios.post(Url, data);
};

export default ApiInfo_api;
