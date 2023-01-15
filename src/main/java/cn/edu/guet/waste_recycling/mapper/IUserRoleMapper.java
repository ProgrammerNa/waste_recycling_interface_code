package cn.edu.guet.waste_recycling.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author HHS
 */
@Mapper
public interface IUserRoleMapper {
    boolean insertURByUId(long uid, long rid);
    boolean updateURByUId(long uid, long rid);
}
