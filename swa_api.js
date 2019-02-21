import apiconfig from '../config.js';
let Url=global.swagger;
let swa_api = {};


swa_api.readJson=function(form,data){
    return this.post(Url+"/readJson",form,data);
};
//调用get方法
swa_api.get = function (Url,form) {
    return form.axios.get(Url);
};
//调用post方法
swa_api.post = function (Url,form, data) {
    return form.axios.post(Url, data);
};
export default swa_api;
