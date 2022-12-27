package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.LoginBean;
import cn.edu.guet.waste_recycling.bean.User;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HHS
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getImfo")
    public HttpResult getUserImfo(@RequestParam String username){
        User user = userService.findUserByName(username);
        return HttpResult.ok(user);
    }
}
