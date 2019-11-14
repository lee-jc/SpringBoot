package lee.example.testspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload(){
        //通过get请求转发到视图解析器相应的jsp文件
        return "upload";
    }

    @PostMapping("/upload")//通过表单请求而来
    @ResponseBody//需要返回json而不是页面
    public String upload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "文件为空，请重新上传";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String filePath = "d:/temp/";
        File uploadFile = new File(filePath+fileName);
        if(!uploadFile.getParentFile().exists()){//判断父类路径是否存在
            uploadFile.getParentFile().mkdirs();//不存在则递归创建
        }
        try{
            file.transferTo(uploadFile);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(),e);
        }
        return "上传失败";

    }
}
