package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHS
 */
@RestController
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @GetMapping("/getArea")
    public HttpResult getArea(){
        return HttpResult.ok(areaService.getAreas());
    }
}
