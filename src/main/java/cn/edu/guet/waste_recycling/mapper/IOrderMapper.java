package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IOrderMapper {
    List<Order> getOrders();
}
