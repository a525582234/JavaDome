package com.wty.report.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname test1
 * @Description TODO
 * @Date 2022/1/10 16:40
 * @@author wty
 */
@Data
@TableName(value = "`test1`")
public class test1 implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    Integer siteid;
    @TableField(value = "citycode")
    Integer citycode;
    @TableField(value = "username")
    String username;
    @TableField(value = "pv")
    Integer pv;
}
