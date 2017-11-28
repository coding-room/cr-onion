package cr.onion.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Beldon.
 * Copyright (c)  2017/6/25, All Rights Reserved.
 * http://beldon.me
 */
@ConfigurationProperties(prefix = "site")
public class SiteConfig {

    /**
     * 上传文件的路径
     */
    private String uploadPath;

    /**
     * 上传文件的url显示的路径
     */
    private String uploadFileUrlPath = "/upload";

    /**
     * 图片保存的路径，是uploadPth+imagePath
     */
    private String imagePath = "/images/avatar";


    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileUrlPath() {
        return uploadFileUrlPath;
    }

    public void setUploadFileUrlPath(String uploadFileUrlPath) {
        this.uploadFileUrlPath = uploadFileUrlPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
