package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.User;
import cn.edu.guet.waste_recycling.mapper.IUserMapper;
import cn.edu.guet.waste_recycling.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HHS
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
