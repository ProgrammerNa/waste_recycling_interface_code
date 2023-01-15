package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.User;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IUserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @PostMapping("/addUser")
    public HttpResult addUser(@RequestBody ObjectNode json){
        String username = json.get("username").toString().replace("\"", "");
        String password = json.get("password").toString().replace("\"", "");
        String repassword = json.get("repassword").toString().replace("\"", "");
        int roleNum = json.get("role").intValue();

        if (!password.equals(repassword)) {
            return HttpResult.error("注册失败！两次输入的密码不一致");
        }
        return HttpResult.ok(userService.insertUser(username, password, roleNum));
    }

    @GetMapping("/getImfo")
    public HttpResult getUserImfo(@RequestParam String username){
        User user = userService.findUserByName(username);
        return HttpResult.ok(user);
    }

    @PostMapping("/modifyImfo")
    public HttpResult modifyUserImfo(@RequestBody User user){
        if (!userService.updateUserImfo(user)) {
            return HttpResult.error("修改个人信息失败");
        }
        User newUser = userService.findUserByName(user.getName());
        return HttpResult.ok(newUser);
    }

    @PostMapping("/modifyPassword")
    public HttpResult modifyPassword(@RequestBody ObjectNode json){
        String username = json.get("username").toString().replace("\"", "");
        String password = json.get("password").toString().replace("\"", "");
        String repassword = json.get("repassword").toString().replace("\"", "");

        if (!password.equals(repassword)) {
            return HttpResult.error("修改密码失败！两次输入的密码不一致");
        }
//        if (userService.findUserByName(username) == null) {
//            return HttpResult.error("账号不存在");
//        }
        return HttpResult.ok(userService.updatePassword(username, password));
    }
}
