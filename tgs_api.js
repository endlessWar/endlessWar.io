let tgs_api = {};
let url = global.Provider;
//带页数获取列表
tgs_api.getPage = function(form,data){
    return this.post(url + "/show",form,data);
};
//获取全部数据
tgs_api.getAll = function(form,data){
    return this.post(url+"/list",form,data);
};
//添加一行数据
tgs_api.addOne = function(form,data){
    return this.post(url+"/add",form,data)
};
//获取某行数据的信息
tgs_api.getById = function(guid,form,data){
    return this.post(url+"/get/"+guid,form,data);
};
//更新某行数据的信息
tgs_api.update = function(form,data){
    return this.post(url+"/update",form,data);
};
//调用get方法
tgs_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
tgs_api.post = function (Url, form, data) {
    return form.axios.post(Url, data);
};
export default tgs_api;
