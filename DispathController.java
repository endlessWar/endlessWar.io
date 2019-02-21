package cn.com.oceansoft.osc.ms.controller;

import cn.com.oceansoft.osc.ms.common.domain.ApiPager;
import cn.com.oceansoft.osc.ms.domain.DispatchMessage;
import cn.com.oceansoft.osc.ms.domain.DispathQueryBase;
import cn.com.oceansoft.osc.ms.service.IDispathService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 冯怿
 *
 */
@Api("指挥调度相关接口")
@RestController
@RequestMapping("dispath")
public class DispathController {
    @Resource
    IDispathService dispathService;

    @ApiOperation("增加一条指挥调度信息")
    @PostMapping("addmessage")
    public ApiResult addmessage(@RequestBody DispatchMessage dispatchMessage){
        return dispathService.addmessage(dispatchMessage);
    }

    @ApiOperation("增加一条旧指挥调度信息")
    @PostMapping("addOldOne")
    public ApiResult addOldOne(@RequestBody DispatchMessage dispatchMessage){
        return dispathService.addOldOne(dispatchMessage);
    }

    @ApiOperation("结束一条指挥调度信息")
    @PostMapping("endmessage")
    public ApiResult endmessage(@RequestBody DispatchMessage dispatchMessage){
        return dispathService.endmessage(dispatchMessage);
    }

    @ApiOperation("修改一条指挥调度信息")
    @PostMapping("updatemessage")
    public ApiResult updatemessage(@RequestBody DispatchMessage dispatchMessage){
        return dispathService.updatemessage(dispatchMessage);
    }

    @ApiOperation("删除一条指挥调度信息")
    @GetMapping("delmessage/{guid}")
    public ApiResult delmessage(@PathVariable String guid){
        return dispathService.delmessage(guid);
    }

    @ApiOperation("查询一条指挥调度信息")
    @GetMapping("getmessage/{guid}")
    public ApiResult getmessage(@PathVariable String guid){
        return dispathService.getmessage(guid);
    }

    @ApiOperation("查询指挥调度信息分页列表")
    @PostMapping("searchmessage")
    public ApiPager<DispatchMessage> searchmessage(@RequestBody DispathQueryBase dispathQueryBase){
        return dispathService.searchmessage(dispathQueryBase);
    }

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "listUser", method= RequestMethod.GET)
    public ApiResult getUserListByOrg(){
        return dispathService.getUserList();
    }
}
