package com.example.demo.upload;

import com.example.demo.upload.entity.EasyUiForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    //todo asyn upload file
    @PostMapping("/syn/upload")
    @ResponseBody
    public Map<String, String> synUpload(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        // TODO 将文件写入到指定目录
        file.transferTo(new File("D:\\IdeaProjects\\Springboot-Integration\\src\\main\\java\\com\\example\\demo\\" + file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>(16);
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;

    }
    //todo asyn upload file
    @RequestMapping(value = "/asyn/upload", method = RequestMethod.POST)
    @ResponseBody
    public String asynUpload(MultipartFile file) throws Exception {
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        file.transferTo(new File("D:\\IdeaProjects\\Springboot-Integration\\src\\main\\java\\com\\example\\demo\\" + file.getOriginalFilename()));
        return "AsynSuccess";
    }
    //todo submit form and file(multipart/form-data)
    @RequestMapping(value = "/asyn/submit", method = RequestMethod.POST)
    @ResponseBody
    public boolean asynSubmitForm(EasyUiForm easyUiForm) throws Exception {
        MultipartFile file = easyUiForm.getFile();
        logger.info("[name is : {} ]",easyUiForm.getName());
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        file.transferTo(new File("D:\\IdeaProjects\\Springboot-Integration\\src\\main\\java\\com\\example\\demo\\" + file.getOriginalFilename()));
        return true;
    }

}