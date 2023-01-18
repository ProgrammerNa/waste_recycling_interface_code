package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IOrderMapper {
    Order getOrderByDate(String date);
    List<Order> getOrders();
    List<Order> getOrdersByUId(long id);

    boolean insertOrder(Order order);
    boolean updateStatus(@Param(value = "orderId") long orderId, @Param(value = "status") int status);
}
