/**
 * 
 */
package cn.com.oceansoft.osc.ms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import cn.com.oceansoft.osc.ms.domain.AsseUnit;
import cn.com.oceansoft.osc.ms.domain.AsseUnitDetails;
import cn.com.oceansoft.osc.ms.domain.AsseUnitType;
import cn.com.oceansoft.osc.ms.service.IAssemblyUnitService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 崔晋雄
 * 
 *         部件相关接口
 */
@Api("部件相关接口")
@RestController
@RequestMapping("asse-unit")
public class AssemblyUnitController {

	@Resource
	private IAssemblyUnitService assemblyUnitService;
	
	@ApiOperation("获取部件类别")
	@ApiImplicitParam(value = "获取部件类别", dataType = "String", name = "parentCode", paramType = "path", required = true)
	@GetMapping("asse-unit-type/{parentCode}")
	public ApiResult<List<AsseUnitType>> getAsseUnitType(@PathVariable String parentCode) {
		return assemblyUnitService.getAsseUnitType(parentCode);
	}
	@ApiOperation("获取部件")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "部件类型编码", dataType = "String", name = "asseUnitType", paramType = "path", required = true),
		@ApiImplicitParam(value = "部门id", dataType = "String", name = "belongDept", paramType = "path", required = true)
	})
	@GetMapping("asse-unit/{asseUnitType}/{belongDept}/{bjCode}/{checkStatus}")
	public ApiResult<List<AsseUnit>> findAsseUnit(@PathVariable String asseUnitType,@PathVariable String belongDept,@PathVariable String bjCode,@PathVariable String checkStatus){
		return assemblyUnitService.findAsseUnit(asseUnitType,belongDept,bjCode,checkStatus);
	}
	@ApiOperation("获取部件")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "部件编码", dataType = "String", name = "asseUnitType", paramType = "path", required = true),
			@ApiImplicitParam(value = "部门id", dataType = "String", name = "belongDept", paramType = "path", required = true)
	})
	@GetMapping("asse-unit-byCode/{asseUnitCode}/{belongDept}/{checkStatus}")
	public ApiResult<List<AsseUnit>> findAsseUnitByCode(@PathVariable String asseUnitCode,@PathVariable String belongDept,@PathVariable String checkStatus){
		return assemblyUnitService.findAsseUnitByCode(asseUnitCode,belongDept,checkStatus);
	}
	@GetMapping("changeStatue/{guid}/{checkStatus}")
	public ApiResult<List<AsseUnit>> changeStatue(@PathVariable String guid,@PathVariable String checkStatus){
		return assemblyUnitService.changeStatue(guid,Integer.parseInt(checkStatus));
	}
	@ApiOperation("获取部件详情")
	@ApiImplicitParam(value = "部件编码", dataType = "String", name = "guid", paramType = "path", required = true)
	@GetMapping("asse-unit-details/{guid}")
	public ApiResult<AsseUnitDetails> getAsseUnitDetails(@PathVariable String guid){
		return assemblyUnitService.getAsseUnitDetails(guid);
	}
	
	@ApiOperation("获取部件分类统计")
	@ApiImplicitParam(value = "部门id", dataType = "String", name = "belongDept", paramType = "path", required = true)
	@GetMapping("asse-unit-type-count/{belongDept}")
	public ApiResult<List<Map<String, Object>>> getAsseUnitTypeCount(@PathVariable String belongDept){
		return assemblyUnitService.getAsseUnitTypeCount(belongDept);
	}
	@ApiOperation("获取部件状态统计")
	@ApiImplicitParam(value = "部门id", dataType = "String", name = "belongDept", paramType = "path", required = true)
	@GetMapping("asse-unit-status-count/{belongDept}")
	public ApiResult<List<Map<String, Object>>> getAsseUnitStatusCount(@PathVariable String belongDept){
		return assemblyUnitService.getAsseUnitStatusCount(belongDept);
	}
}
