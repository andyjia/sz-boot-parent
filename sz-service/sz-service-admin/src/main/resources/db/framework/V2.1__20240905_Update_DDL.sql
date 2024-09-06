-- 新增模版文件
CREATE TABLE `sys_temp_file` (
                                     `id` int NOT NULL,
                                     `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模版文件名称',
                                     `permissions` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标识，唯一',
                                     `ext` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '扩展类型，文件后缀',
                                     `path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件路径',
                                     `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件地址',
                                     `history` json DEFAULT NULL COMMENT '历史记录',
                                     `create_id` int DEFAULT NULL COMMENT '创建人',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_id` int DEFAULT NULL COMMENT '更新人',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `del_flag` enum('T','F') COLLATE utf8mb4_general_ci DEFAULT 'F' COMMENT '删除标识',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='模版文件表';