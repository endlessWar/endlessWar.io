import apiconfig from '../config.js';
let Url=global.user;
let user_api = {};

//查询所有数据
user_api.getFind=function(form,data){
    return this.post(Url+"/find",form,data);
};
//通过名字查询数据
user_api.getUserName=function(form,data){
    return this.post(Url+"/findUserName",form,data);
};
//根据id查询数据
user_api.getstate=function (form,id) {
    return this.get(Url+"/find/"+id,form);
};
//添加一行数据
user_api.addOne = function(form,data){
    return this.post(Url+"/add",form,data)
};
//根据id删除数据
user_api.delById=function (form,data) {
    return this.get(Url+"/del/"+data.id,form);
};
//修改数据信息
user_api.updateInfo=function (form,data) {
    return this.post(Url+"/set",form,data);
};
//修改状态
user_api.updateStatus=function(form,data){
    return this.post(Url+"/setStatus",form,data)
};
//分页
user_api.userPage=function (form,data) {
    return this.post(Url+"/page",form,data)
};
//中间表插入数据
user_api.addUserRole=function(form,data){
    return this.get(Url+"/adduser/"+data.uid+"/"+data.rid,form);
};
//修改中间表数据
user_api.updateId=function(form,data){
    return this.post(Url+"/setId",form,data);
};
//调用get方法
user_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
user_api.post = function (Url,form, data) {
    return form.axios.post(Url, data);
};

export default user_api;
