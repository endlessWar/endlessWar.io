import apiconfig from '../config.js';
let Url=global.menu;
let zygl_api = {};

//查询所有数据
zygl_api.getFind=function(form,data){
    return this.post(Url+"/find",form,data);
};
//分页查询资源
zygl_api.show=function(form,data){
    return this.post(Url+"/show",form,data);
};
//根据id查询数据
zygl_api.getstate=function (form,id) {
    return this.get(Url+"/find/"+id,form);
};
//添加一行数据
zygl_api.addOne = function(form,data){
    return this.post(Url+"/add",form,data)
};
//根据id删除数据
zygl_api.delById=function (form,data) {
    return this.get(Url+"/del/"+data.id,form);
};
//修改数据信息
zygl_api.updateInfo=function (form,data) {
    return this.post(Url+"/set",form,data);
};
//修改状态
zygl_api.updateStatus=function(form,data){
    return this.post(Url+"/setStatus",form,data)
};
//分页
zygl_api.menuPage=function (from,data) {
    return this.post(Url+"/page",from,data)
};
//调用get方法
zygl_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
zygl_api.post = function (Url,form, data) {
    return form.axios.post(Url, data);
};

export default zygl_api;
