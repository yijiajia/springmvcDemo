package com.example.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class UploadController {

    /**
     * 页面跳转
     */
    @RequestMapping(value = "/toUpload")
    public String toUpload() {
        return "upload";
    }

    /**
     * 上传接口
     * @param file 使用 MultipartFile 作为参数属性，接收multipart/form-data类型的参数文件
     */
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("E:\\code\\log\\" + file.getOriginalFilename()),file.getBytes());
            return "ok";
        }catch (Exception e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
