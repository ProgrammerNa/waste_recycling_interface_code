package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.OrderDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HHS
 */
@Mapper
public interface IDetailsMapper {
    boolean insertDetail(OrderDetails orderDetails);// 插入详情记录并返回其id
}
