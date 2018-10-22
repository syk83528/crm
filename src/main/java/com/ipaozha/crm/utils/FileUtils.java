package com.ipaozha.crm.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    /**
     *
     * @param file 文件
     * @param path 文件根路径
     * @param module 文件存放的模块路径
     * @return 文件路径名
     */
    public static String upload(MultipartFile file, String path, String module){
        // 图片名为空
        if (StringUtils.isBlank(file.getOriginalFilename())) {
            return null;
        }

        //存储到数据库的路径
        String filePath = module + "/" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        //存储到文件的路径
        String realPath = path + filePath;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return filePath;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }
}
