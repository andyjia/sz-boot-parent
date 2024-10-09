package com.sz.alioss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class AliOSSService {

    @Resource
    private OSSClient ossClient;

    @Resource
    private AliOSSProperties aliOSSProperties;

    /**
     * 上传
     * @param file
     * @param objectName
     * @return
     */
    @SneakyThrows
    public PutObjectResult uploadFile(MultipartFile file, String objectName) {
        InputStream inputStream = file.getInputStream();
        try {
            return ossClient.putObject(aliOSSProperties.getBucketName(), objectName, inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 获取文件地址
     * @return
     */
    @SneakyThrows
    public String getPublicObjectUrl(String fileName) {
        return "https://" + aliOSSProperties.getBucketName() + "." + aliOSSProperties.getEndpoint() + "/" + fileName;
    }
}
