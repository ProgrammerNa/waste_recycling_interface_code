package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HHS
 */
@Mapper
public interface IUserMapper {
    User findUserByName(String username);
    boolean updateUserImfo(User user);
}
