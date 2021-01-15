package com.shizg.study.demo.wxgz.domain.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 项目户型表
 * </p>
 *
 * @author wenyilu
 * @since 2020-08-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value="TPaMessageBO", description="爬虫信息表")
public class TPaMessageBO {


    @ApiModelProperty(value = "信息")
    private List<String> tests;

    @ApiModelProperty(value = "类型 1爱 2 年")
    private Integer type;




}
