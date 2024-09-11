package com.sz.admin.system.pojo.dto.systempfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName TempFileRecord
 * @Author sz
 * @Date 2024/9/11 15:56
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempFileRecord {

    private String url;

    private LocalDateTime time;

}
