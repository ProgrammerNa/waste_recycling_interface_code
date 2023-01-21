package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import cn.edu.guet.waste_recycling.service.IImageService;
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
    public HttpResult submitApplication(Application application) {
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
