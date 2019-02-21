/**
 * 
 */
package cn.com.oceansoft.osc.ms.controller;

import cn.com.oceansoft.osc.ms.domain.AskOldWay;
import cn.com.oceansoft.osc.ms.domain.CarTree;
import cn.com.oceansoft.osc.ms.service.ICarService;
import cn.com.oceansoft.osc.ms.service.IPersonService;
import cn.ucox.web.framework.view.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 崔晋雄
 *
 */
@Api("车辆相关接口")
@RestController
@RequestMapping("car")
public class CarController {
    @Resource
    ICarService carService;

    @ApiOperation("车辆结构树")
    @GetMapping("getTree")
    public ApiResult findCarTree(){
        return carService.getTree();
    }

    @ApiOperation("在线车辆列表")
    @GetMapping("getOnlineCar")
    public ApiResult getOnlineCar(){
        return carService.getOnlineCar();
    }

    @ApiOperation("获取全部使用单位")
    @GetMapping("getUseUnit")
    public ApiResult getUseUnit(){
        return carService.getUseUnit();
    }

    @ApiOperation("获取历史轨迹")
    @ApiImplicitParam(value = "查询条件", dataType = "cn.com.oceansoft.osc.ms.domain.AskOldWay", name = "time", paramType = "body", required = true)
    @PostMapping("getOldWay")
    public ApiResult getOldWay(@RequestBody AskOldWay askOldWay){
        return carService.getOldWay(askOldWay);
    }

    @ApiOperation("获取车辆列表")
    @ApiImplicitParam(value = "查询条件", dataType = "java.lang.list", name = "carList", paramType = "body", required = true)
    @PostMapping("getCarTable")
    public ApiResult getCarTable(@RequestBody List<CarTree> carList){
        return carService.getCarTable(carList);
    }

    @ApiOperation("获取车辆信息")
    @ApiImplicitParam(value = "车辆id", dataType = "String", name = "guid", paramType = "path", required = true)
    @GetMapping("getCarInfo/{guid}")
    public ApiResult getCarInfo(@PathVariable String guid){
        return carService.getCarInfo(guid);
    }

    @GetMapping("changePoint")
    public ApiResult changePoint(){
        return carService.changePoint();
    }
}
