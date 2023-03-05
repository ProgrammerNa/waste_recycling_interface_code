package cn.edu.guet.waste_recycling.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HHS
 */
@Mapper
public interface IOrderDetailsMapper {
    long getDidByOid(long oid);// 按理来说一个订单id可以对应多个详情id（即对应多个商品信息，该返回List<...>）
    boolean insertOD(@Param(value = "oid") long oid, @Param(value = "did") long did);
}
