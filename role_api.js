import apiconfig from '../config.js';
let Url=global.role;
let role_api = {};
//查询所有数据
role_api.getFind=function(form,data){
    return this.post(Url+"/find",form,data);
};
//根据id查询数据
role_api.getstate=function (form,id) {
    return this.get(Url+"/find/"+id,form);
};
//根据角色名称查询
role_api.getRoleValue=function(form,data){
    return this.get(Url+"/findByValue/"+data.value,from);
};
//添加一行数据
role_api.addOne = function(form,data){
    return this.post(Url+"/add",form,data)
};
//根据id删除数据
role_api.delById=function (form,data) {
    return this.get(Url+"/del/"+data.id,form);
};
//修改数据信息
role_api.updateInfo=function (form,data) {
    return this.post(Url+"/set",form,data);
};
//分页
role_api.rolePage=function (from,data) {
    return this.post(Url+"/page",from,data)
};
//调用get方法
role_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
role_api.post = function (Url,form, data) {
    return form.axios.post(Url, data);
};

export default role_api;
