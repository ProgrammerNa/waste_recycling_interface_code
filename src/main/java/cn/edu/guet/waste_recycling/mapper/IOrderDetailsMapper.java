package cn.edu.guet.waste_recycling.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HHS
 */
@Mapper
public interface IOrderDetailsMapper {
    boolean insertOD(@Param(value = "oid") long oid, @Param(value = "did") long did);
}
