package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author HHS
 */
public interface IUserService {
    User findUserByName(String username);
}