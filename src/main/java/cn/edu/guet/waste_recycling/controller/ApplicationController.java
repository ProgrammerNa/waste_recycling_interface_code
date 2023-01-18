package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHS
 */
@RestController
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping("/submitApplication")
    public HttpResult submitApplication(Application application) {
        return HttpResult.ok(applicationService.submitApplication(application));
    }
}
