/**
 * 
 */
package cn.com.oceansoft.osc.ms.controller;

import cn.com.oceansoft.osc.ms.domain.ReadWorkListWay;
import cn.com.oceansoft.osc.ms.domain.WorkList;
import cn.com.oceansoft.osc.ms.service.IPersonService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @author 崔晋雄
 *
 */
@Api("人员相关接口")
@RestController
@RequestMapping("person")
public class PersonController {
    @Resource
    IPersonService personService;

    @ApiOperation("获取部门人员树")
    @ApiImplicitParam(value = "部门id", dataType = "String", name = "belongDept", paramType = "path", required = true)
    @GetMapping("getTree/{belongDept}")
    public ApiResult findAsseUnitByCode(@PathVariable String belongDept){
        return personService.getTree(belongDept);
    }

    @ApiOperation("获取信息员树")
    @GetMapping("getxxy")
    public ApiResult getxxy(){
        return personService.getxxy();
    }

    @ApiOperation("获取底层地图")
    @GetMapping("getmapper")
    public ApiResult getmapper(){
        return personService.getmapper();
    }

    @ApiOperation("获取在线人员")
    @GetMapping("getOnlinePeople")
    public ApiResult getOnlinePeople(){
        return personService.getOnlinePeople();
    }

    @ApiOperation("递归获取网格所有子节点")
    @ApiImplicitParam(value = "当前人员部门id", paramType = "path", name = "deptId", dataType = "String", required = true)
    @GetMapping(value = "get-list-new/{deptId}")
    public ApiResult getGisListByRecursiveNew(@PathVariable("deptId") String deptId) {
        return personService.getGisByRecursiveNew(deptId);
    }

    @ApiOperation("获取工单统计")
    @ApiImplicitParam(value = "当前人员id", paramType = "body", name = "deptId", dataType = "String", required = true)
    @PostMapping(value = "getWorkCount")
    public ApiResult getWorkCount(@RequestBody ReadWorkListWay readWorkListWay) {
        return personService.getWorkCount(readWorkListWay);
    }

    @ApiOperation("用户详细信息")
    @ApiImplicitParam(value = "查询条件", paramType = "path", name = "userGuid", dataType = "String", required = true)
    @RequestMapping(value = "detail/{userGuid}", method= RequestMethod.GET)
    public ApiResult getUserDetail(@PathVariable("userGuid") String userGuid){
        return personService.getUserDetail(userGuid);
    }

    @ApiOperation("获取工单列表")
    @ApiImplicitParam(value = "查询条件", paramType = "body", name = "workList", dataType = "cn.com.oceansoft.osc.ms.domain.WorkList", required = true)
    @RequestMapping(value = "getWorkList", method= RequestMethod.POST)
    public ApiResult getWorkList(@RequestBody WorkList workList){
        return personService.getWorkList(workList);
    }

    @ApiOperation("查询历史轨迹")
    @ApiImplicitParam(value = "查询条件", paramType = "body", name = "workList", dataType = "cn.com.oceansoft.osc.ms.domain.WorkList", required = true)
    @RequestMapping(value = "getUserTrails", method= RequestMethod.POST)
    public ApiResult getUserTrails(@RequestBody WorkList workList){
        return personService.getUserTrails(workList);
    }

    @ApiOperation("用户签到点获取")
    @ApiImplicitParam(value = "查询条件", paramType = "path", name = "userGuid", dataType = "String", required = true)
    @RequestMapping(value = "points/{userGuid}", method= RequestMethod.GET)
    public ApiResult getUserPoints(@PathVariable("userGuid") String userGuid){
        return personService.getUserPoints(userGuid);
    }
}
