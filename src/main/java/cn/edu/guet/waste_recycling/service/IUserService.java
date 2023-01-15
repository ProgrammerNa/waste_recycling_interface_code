package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.User;

/**
 * @author HHS
 */
public interface IUserService {
    User findUserByName(String username);
    boolean insertUser(String username, String password, int roleNum);
    boolean updateUserImfo(User user);
    boolean updatePassword(String username, String password);
}
