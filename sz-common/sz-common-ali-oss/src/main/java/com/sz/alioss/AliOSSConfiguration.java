package com.sz.alioss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliOSSConfiguration {

    @Resource
    private AliOSSProperties aliOSSProperties;

    @Bean
    public OSS ossClient() {
        return new OSSClientBuilder()
                .build(aliOSSProperties.getEndpoint(), aliOSSProperties.getAccessKeyId(), aliOSSProperties.getAccessKeySecret());
    }
}
