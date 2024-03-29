package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HHS
 */
@Mapper
public interface IOrderMapper {
    Order getOrderByDate(String date);
    List<Order> getOrders();
    List<Order> getOrdersByUId(long id);
    List<Order> getOrdersByRId(long id);
    List<Order> getAcceptableOrders();

    boolean insertOrder(Order order);
    boolean updateStatus(@Param(value = "orderId") long orderId, @Param(value = "status") int status);
    boolean acceptOrderByRec(@Param(value = "orderId") long orderId, @Param(value = "recyclerId") long recyclerId);
    boolean updateCanApplication(@Param(value = "id") long id, @Param(value = "canApplication") int canApplication);
    List<Order> getOrderStatistics(@Param(value = "id") long id, @Param(value = "year") String year);
}
