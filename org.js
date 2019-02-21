import apiconfig from '../config.js';
var url = global.orgUrl;


var org_api = {};
var org_guid = 'a91edcfaa1d849718f00237e49d8ee02';


org_api.loadOrg = function (form, id) {
    let pid = org_guid;
    if (id)
        pid = id;
    var bindUrl = url + '/v1/departments/' + pid + '/sub-departments';
    return form.axios.get(bindUrl);
},
    org_api.insert = function (form, data) {
        var bindUrl = url + '/v1/departments';
        return form.axios.post(bindUrl, data);

    },
    org_api.orgDetail = function (form, id) {
        var bindUrl = url + '/v1/departments/' + id;
        return form.axios.get(bindUrl);
    },
    org_api.orgEdit = function (form, data, id) {
        var bindUrl = url + '/v1/departments/' + id;
        return form.axios({
            method: "put",
            url: bindUrl,
            data: data
        });
    },
    org_api.orgDelete = function (form, id) {
        var bindUrl = url + '/v1/departments/' + id;
        return form.axios.delete(bindUrl);
    },
    org_api.userFind=function (form,orgId,userName,userId,pi,ps,qyType) {
        let pageSize=20;
        if(ps)
            pageSize=ps;
        let bindUrl=url+'/v1/departments/users?size='+pageSize+'&page='+pi;
        if(qyType=='0')
        {
            if(userName.trim()!='')
                bindUrl=bindUrl+'&userName='+userName;
            if(userId.trim()!='')
                bindUrl=bindUrl+"&userId="+userId;
        }
        else
        {
            if(orgId.trim()!='')
                bindUrl=bindUrl+'&deptGuid='+orgId;
        }
        return form.axios.get(bindUrl);

    },

    org_api.editUserStatus=function (form,data) {
        let bindUrl=url+'/v1/users';
        return form.axios.put(bindUrl,data);
    },

    org_api.resetPwd=function (form,data) {
        let bindUrl=url+'/v1/profile/passphrase/'+data+'/retrieve';
        return form.axios.post(bindUrl);
    },
    org_api.delUsers = function (form,data) {
        let bindUrl=url+'/v1/users/del';
        return form.axios.post(bindUrl,data);
    },

    org_api.insertUser =function (form,data) {
        let bindUrl=url+'/v1/users';
        return form.axios.post(bindUrl,data);
    },

    org_api.getUsers=function (form,id) {

        let bindUrl=url+'/v1/users/'+id;
        return form.axios.get(bindUrl);
    },
    org_api.isExistUser = function (form,data) {
        let bindUrl=url+'/v1/user/verification';
        return form.axios.post(bindUrl,data);
    },
    org_api.getResourse=function (form) {
        let bindUrl=url+'v1/sys/resources';
        return form.axios.get(bindUrl);
    },
    org_api.getUserResourse=function (form,id) {
        let bindUrl=url+'/v1/users/'+id+'/permission';
        return form.axios.get(bindUrl);
    },
    org_api.saveRole=function (form,id,data) {
        let bindUrl=url+ '/v1/users/'+id+'/permission';
        return form.axios.put(bindUrl,data);
    },
    org_api.getTokenUser = function (form,id) {
        let bindUrl =url+'/v1/profile/member/'+id
        return form.axios.get(bindUrl);
    }







export default  org_api;
