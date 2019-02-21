let model_api = {};
let url = global.Model;
//带页数获取列表
model_api.getPage = function(form,data){
    return this.post(url + "/show",form,data);
};
//获取全部数据
model_api.getAll = function(form,data){
    return this.post(url+"/list",form,data);
};
//添加一行数据
model_api.addOne = function(form,data){
    return this.post(url+"/add",form,data)
};
//获取某行数据的信息
model_api.getById = function(guid,form,data){
    return this.post(url+"/get/"+guid,form,data);
};
model_api.getByMircoGuid = function(guid,form,data){
    return this.post(url+"/getByMirco/"+guid,form,data);
};
//更新某行数据的信息
model_api.update = function(form,data){
    return this.post(url+"/update",form,data);
};
//调用get方法
model_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
model_api.post = function (Url, form, data) {
    return form.axios.post(Url, data);
};


export default model_api;
