package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import cn.edu.guet.waste_recycling.service.IImageService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author HHS
 */
@RestController
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;
    @Autowired
    private IImageService imageService;

    @PostMapping("/submitApplication")
    public HttpResult submitApplication(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        double expenses = json.get("expenses").asDouble();
        String picUrl = json.get("picUrl").asText();
        String evidence = json.get("evidence").asText();
        Application application = new Application(orderId, expenses, picUrl, evidence);
        return HttpResult.ok(applicationService.submitApplication(application));
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public void uploadImage(@RequestParam MultipartFile[] files, @RequestParam long orderId) {
//        long orderId = 1;
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (!file.isEmpty()) {
                imageService.uploadimage(file, String.valueOf(orderId));
            }
        }
    }

    @GetMapping("/getImage")
    @ResponseBody
    public void getImage(@RequestParam String filename, @RequestParam HttpServletResponse response){
        imageService.getImage(filename, response);
    }
}
