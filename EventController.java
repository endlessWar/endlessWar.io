package cn.com.oceansoft.osc.ms.controller;

import cn.com.oceansoft.osc.ms.domain.AsseUnitType;
import cn.com.oceansoft.osc.ms.domain.EventDetail;
import cn.com.oceansoft.osc.ms.domain.EventUnit;
import cn.com.oceansoft.osc.ms.domain.Tree;
import cn.com.oceansoft.osc.ms.service.IAssemblyUnitService;
import cn.com.oceansoft.osc.ms.service.IEventService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: 陆俊杰
 * @Date: 2018/10/16 10:31
 *
 * 事件案件相关接口
 */
@Api("事件案件接口")
@RestController
@RequestMapping("sjaj")
public class EventController {
    @Resource
    private IEventService eventService;

    /**
     * 获取工单类型（事件/案件）
     * @param parentCode
     * @return
     */
    @ApiOperation("获取工单类型（事件/案件）")
    @RequestMapping(value = "sysdict/get/gdlx/{parentCode}",method = RequestMethod.GET)
    public ApiResult<List<Tree>> selectSysDictCase(@PathVariable String parentCode){
        return eventService.selectSysDictCase(parentCode);
    }


    @GetMapping("eventCase/{caseCode}/{belongDept}/{ajCode}")
    public ApiResult<List<EventUnit>> findEventUnit(@PathVariable String caseCode, @PathVariable String belongDept, @PathVariable String ajCode){
        return eventService.findEventUnit(caseCode,belongDept,ajCode);
    }

    @ApiOperation("获取部件详情")
    @GetMapping("geteventdetails/{guid}")
    public ApiResult<EventDetail> getEventUnitDetails(@PathVariable String guid){
        return eventService.getEventUnitDetails(guid);
    }

    @ApiOperation("获取工单事件部件分类统计")
    @GetMapping("event-type-count/{parentCode}/{belongDept}")
    public ApiResult<List<Map<String, Object>>> getAsseUnitTypeCount(@PathVariable String parentCode,@PathVariable String belongDept){
        return eventService.getEventTypeCount(parentCode,belongDept);
    }

    @ApiOperation("获取工单状态统计")
    @GetMapping("event-state-count/{state}/{deptGuid}")
    public ApiResult<List<Map<String, Object>>> getEventStateCount(@PathVariable Integer state,@PathVariable String deptGuid){
        return eventService.getEventStateCount(state,deptGuid);
    }

}
