package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {
//    @Autowired
//    private AliOssUtil aliOssUtil;
    //文件上传
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
        try {
            log.info("文件上传:{}", file);
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀
            String extension =  originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新的文件名
            String objectName = UUID.randomUUID().toString() + extension;
            //保存文件到本地C:\Users\chy\Downloads\itheima\nginx-1.20.2\html\sky\images目录
            file.transferTo(new java.io.File("C:\\Users\\chy\\Downloads\\itheima\\nginx-1.20.2\\html\\sky\\images\\" + objectName));
            String filepath = "http://localhost/images/" + objectName;
            return Result.success(filepath);
        } catch (IOException e) {
            log.error("文件上传失败:{}", e);
            return Result.error("文件上传失败");
        }
    }
}
