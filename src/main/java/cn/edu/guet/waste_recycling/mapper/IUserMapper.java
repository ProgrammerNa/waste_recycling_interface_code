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
    User findEasyUser(String username);

    boolean insertUser(@Param(value = "username")String username, @Param(value = "password")String password);
    boolean updateUserImfo(User user);
    boolean updatePassword(@Param(value = "username")String username, @Param(value = "password")String password);
}
