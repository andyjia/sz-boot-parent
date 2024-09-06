package com.sz.admin.system.pojo.po;

import com.mybatisflex.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.io.Serial;
import com.sz.mysql.EntityChangeListener;
import java.time.LocalDateTime;

/**
* <p>
* 模版文件表
* </p>
*
* @author sz-admin
* @since 2024-09-05
*/
@Data
@Table(value = "sys_temp_file", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "模版文件表")
public class SysTempFile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Schema(description ="")
    private Long id;

    @Schema(description ="模版名称")
    private String name;

    @Schema(description ="标识")
    private String permissions;

    @Schema(description ="扩展类型")
    private String ext;

    @Schema(description ="文件路径")
    private String path;

    @Schema(description ="文件地址")
    private String url;

    @Schema(description ="历史记录")
    private String history;

    @Schema(description ="创建人")
    private Long createId;

    @Schema(description ="创建时间")
    private LocalDateTime createTime;

    @Schema(description ="更新人")
    private Long updateId;

    @Schema(description ="更新时间")
    private LocalDateTime updateTime;

    @Column(isLogicDelete = true)
    @Schema(description ="删除标识")
    private String delFlag;

}