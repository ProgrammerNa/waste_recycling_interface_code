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
public class LoginContorller {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public HttpResult findUserByName(@RequestBody LoginBean loginBean){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
//        System.out.println(username+","+password);

        User user = userService.findUserByName(username);
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!user.getPassword().equals(password)) {
            return HttpResult.error("密码不正确");
        }
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定，请联系管理员");
        }

        return HttpResult.ok(user);
    }
}
