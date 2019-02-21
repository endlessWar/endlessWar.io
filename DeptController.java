package cn.com.oceansoft.osc.ms.controller;

import cn.com.oceansoft.osc.ms.service.IDeptService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 冯怿
 */
@Api("部门关系相关接口")
@RestController
@RequestMapping("dept")
public class DeptController {
    @Resource
    private IDeptService deptService;

    @ApiOperation("获取当前部门对应的区id或街道id")
    @ApiImplicitParam(value = "当前部门id", dataType = "String", name = "orgid", paramType = "path", required = true)
    @GetMapping("getrelId/{orgid}")
    public ApiResult<String> getAsseUnitType(@PathVariable String orgid) {
        return deptService.getrelId(orgid);
    }
}
