package com.fj.consul.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Pms表")
public class Pms {
    // @ApiModel  @ApiModelProperty加了这个注释后，在Swagger页面中会显示中文
    @ApiModelProperty("id号")
    private int id;

    @ApiModelProperty("名字")
    @JSONField(name = "name")
    private String name;

    @ApiModelProperty("描述")
//    @JSONField(name = "DE")
    private String des;

    @JSONField(name = "DE")
    public String getDes() {
        return des;
    }

    @JSONField(name = "DE")
    public void setDes(String des) {
        this.des = des;
    }
}
