package com.fj.consul.controller;

import com.fj.consul.entity.Pms;
import com.fj.consul.enums.RequestResultEnum;
import com.fj.consul.model.ResultModel;
import com.fj.consul.service.PmsService;
import com.fj.consul.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class PmsController {

    @Autowired
    PmsService pmsService;

    @GetMapping("/find/{id}")
    public ResultModel find(@PathVariable("id") int id){
        if (StringUtils.isEmpty(id)){
            System.out.println("id"+id);
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

}
