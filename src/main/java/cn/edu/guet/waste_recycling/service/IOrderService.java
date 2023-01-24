package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Order;

import java.util.List;

/**
 * @author HHS
 */
public interface IOrderService {
    List<Order> getOrders();
    List<Order> getOrdersByUId(long id);
    List<Order> getOrdersByRId(long id);
    List<Order> getAcceptableOrders();

    boolean insertOrder(Order order);
    boolean updateStatus(long orderId, int status);
    boolean acceptOrderByRec(long orderId, long recyclerId);
    boolean updateGoodsWeight(long orderId, long goodsId, double weight);
    boolean updateCanApplication(long id, int canApplication);
}
