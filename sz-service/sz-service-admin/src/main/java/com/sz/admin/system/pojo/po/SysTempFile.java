package com.sz.admin.system.pojo.po;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.sz.admin.system.pojo.dto.systempfile.TempFileRecord;
import com.sz.mysql.EntityChangeListener;
import com.sz.platform.handler.SzJacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 模版文件表
 * </p>
 *
 * @author sz-admin
 * @since 2024-09-09
 */
@Data
@Table(value = "sys_temp_file", onInsert = EntityChangeListener.class, onUpdate = EntityChangeListener.class)
@Schema(description = "模版文件表")
public class SysTempFile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    @Schema(description = "")
    private Long id;

    @Schema(description = "模版文件名称")
    private String name;

    @Schema(description = "标识，唯一")
    private String permissions;

    @Schema(description = "扩展类型，文件后缀")
    private String ext;

    @Schema(description = "文件路径")
    private String path;

    @Schema(description = "文件地址")
    private String url;

    @Column(typeHandler = SzJacksonTypeHandler.class)
    @Schema(description = "历史记录")
    private List<TempFileRecord> history;

    @Schema(description = "创建人")
    private Long createId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新人")
    private Long updateId;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Column(isLogicDelete = true)
    @Schema(description = "删除标识")
    private String delFlag;

    @Schema(description = "备注")
    private String remark;

}