package com.fj.consul.controller;

import com.fj.consul.entity.Pms;
import com.fj.consul.enums.RequestResultEnum;
import com.fj.consul.model.ResultModel;
import com.fj.consul.service.PmsService;
import com.fj.consul.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/pms")
@RestController
@Api(value = "PmsController",tags = "Pms接口" )
public class PmsController {

    @Autowired
    PmsService pmsService;

    @GetMapping("/find/{id}")
    public ResultModel find(@PathVariable("id") int id){
        if (StringUtils.isEmpty(id)){
            return ResultUtil.error(RequestResultEnum.FAIL_PARAM_ERROR);
        }

        Pms pms = pmsService.find(id);
        System.out.println("pms-----"+pms);
        if(StringUtils.isEmpty(pms)){


            return ResultUtil.error(RequestResultEnum.FAIL_PARAM_ERROR);
        }

        return ResultUtil.success(pms);
    }

    @PostMapping("/addPms")
    public ResultModel addPms(@RequestBody Pms pms){
        if (StringUtils.isEmpty(pms.getId())){
            return ResultUtil.error(RequestResultEnum.ADD_PMS_ERROR);
        }

        pmsService.add(pms);
        return ResultUtil.success();
    }

    /**
     *@PathVariable，用在参数中,eg: /blogs/1
     * @RequestParam，用在路径中，eg: /hello/?name='fenjia'
     */
    //  @ApiOperation：作用在方法上面，给方法添加一个注释；@ApiParam：作用在参数上面，给参数添加一个注释
    @ApiOperation("hello 访问接口")
    @PutMapping("hello/{name}")
    public String hello(@ApiParam("传入一个名字") @PathVariable("name") String name){
        System.out.println(name);
        return "hello world:"+name;
    }

    @PutMapping("hello1")
    public String hello1(@ApiParam("传入一个名字") @RequestParam(value = "name",required = false,defaultValue = "fengjia") String name){
        System.out.println(name);
        return "hello world:"+name;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

}
