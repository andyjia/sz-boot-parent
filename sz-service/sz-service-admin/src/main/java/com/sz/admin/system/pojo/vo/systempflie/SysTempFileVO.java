package com.sz.admin.system.pojo.vo.systempflie;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * <p>
 * SysTempFile返回vo
 * </p>
 *
 * @author sz-admin
 * @since 2024-09-05
 */
@Data
@Schema(description = "SysTempFile返回vo")
public class SysTempFileVO {

    @Schema(description =  "")
    private Long id;

    @ExcelProperty(value = "模版名称")
    @Schema(description =  "模版名称")
    private String name;

    @ExcelProperty(value = "标识")
    @Schema(description =  "标识")
    private String permissions;

    @ExcelProperty(value = "扩展类型")
    @Schema(description =  "扩展类型")
    private String ext;

    @ExcelProperty(value = "文件路径")
    @Schema(description =  "文件路径")
    private String path;

    @ExcelProperty(value = "文件地址")
    @Schema(description =  "文件地址")
    private String url;

}