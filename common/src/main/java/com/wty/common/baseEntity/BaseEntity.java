package com.wty.common.baseEntity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2021/12/3 16:29
 * @@author wty
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 是否删除（0否1是）
     */
    @TableField(value = "is_delete",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="是否删除（0否1是）")
    private String isDelete;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

    /**
     * 状态
     */
    @TableField(value = "status",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="状态")
    private String status;

    /**
     * 版本
     */
    @TableField(value = "version",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="版本")
    private String version;

    private static final long serialVersionUID = 1L;
}
