package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.User;
import cn.edu.guet.waste_recycling.mapper.IUserMapper;
import cn.edu.guet.waste_recycling.mapper.IUserRoleMapper;
import cn.edu.guet.waste_recycling.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HHS
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IUserRoleMapper userRoleMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public boolean updateUserImfo(User user) {
//        boolean r = false;
//        r = userMapper.updateUserImfo(user);
        return userMapper.updateUserImfo(user);
    }
}
