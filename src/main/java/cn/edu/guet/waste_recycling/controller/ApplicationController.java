package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.bean.ApplicationPic;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import cn.edu.guet.waste_recycling.service.IImageService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
        String evidence = json.get("evidence").asText();
        long recyclerId = json.get("recyclerId").asInt();

        Application application = new Application(orderId, expenses, evidence);
        application.setCreateBy(String.valueOf(recyclerId));
        return HttpResult.ok(applicationService.submitApplication(application));
    }

    @PostMapping("/uploadImage")
    public void uploadImage(@RequestParam MultipartFile[] files, @RequestParam long orderId) {
//        long orderId = 1;
        List<ApplicationPic> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (!file.isEmpty()) {
                String picUrl = imageService.uploadimage(file, String.valueOf(orderId));
                list.add(new ApplicationPic(orderId, picUrl));
            }
        }
        imageService.insertImage(list);
    }

    @GetMapping("/getImage")//x
    @ResponseBody
    public void getImage(@RequestParam String filename, @RequestParam HttpServletResponse response){
        imageService.getImage(filename, response);
    }

    @GetMapping("/getById")
    public HttpResult getById(@RequestParam long id) {
        return HttpResult.ok(applicationService.getById(id));
    }

    @PostMapping("/updateStatus")
    public HttpResult updateApplicationStatus(@RequestBody ObjectNode json) {
        long id = json.get("applicationId").asInt();
        int status = json.get("status").asInt();
        return HttpResult.ok(applicationService.updateStatus(id, status));
    }

    @PostMapping("/updateCanAdd")
    public HttpResult updateCanAdd(@RequestBody ObjectNode json) {
        long id = json.get("applicationId").asInt();
        int canAdd = json.get("canAdd").asInt();
        return HttpResult.ok(applicationService.updateCanAdd(id, canAdd));
    }
}
