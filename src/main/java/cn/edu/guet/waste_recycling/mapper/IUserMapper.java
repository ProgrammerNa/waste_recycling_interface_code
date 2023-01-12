package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HHS
 */
@Mapper
public interface IUserMapper {
    User findUserByName(String username);
    boolean updateUserImfo(User user);
    boolean updatePassword(@Param(value = "username")String username, @Param(value = "password")String password);
}
