package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Order;

import java.util.List;

/**
 * @author HHS
 */
public interface IOrderService {
    List<Order> getOrders();
}