package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.User;
import cn.edu.guet.waste_recycling.mapper.IUserMapper;
import cn.edu.guet.waste_recycling.mapper.IUserRoleMapper;
import cn.edu.guet.waste_recycling.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean insertUser(String username, String password, int roleNum) {
        boolean flag = true;
        flag = userMapper.insertUser(username, password);
        User user = userMapper.findEasyUser(username);

        roleNum = (roleNum == 0) ? 3 : 2;
        flag = userRoleMapper.insertURByUId(user.getId(), roleNum);
        return flag;
    }

    @Override
    public boolean updateUserImfo(User user) {
//        boolean r = false;
//        r = userMapper.updateUserImfo(user);
        return userMapper.updateUserImfo(user);
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return userMapper.updatePassword(username, password);
    }
}
