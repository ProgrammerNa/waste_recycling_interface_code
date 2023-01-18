package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.mapper.IDetailsMapper;
import cn.edu.guet.waste_recycling.mapper.IOrderDetailsMapper;
import cn.edu.guet.waste_recycling.mapper.IOrderMapper;
import cn.edu.guet.waste_recycling.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author HHS
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IDetailsMapper detailsMapper;
    @Autowired
    private IOrderDetailsMapper orderDetailsMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public List<Order> getOrdersByUId(long id) {
        return orderMapper.getOrdersByUId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean insertOrder(Order order) {// 用户下单
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // order表新增记录：用户id、期望上门时间、下单时间、上门回收地址id
        orderMapper.insertOrder(new Order(order.getUserId(), order.getBookDate(), time, order.getAddressId()));
//        orderMapper.insertOrder(new Order(1,1,time));
        long oid = orderMapper.getOrderByDate(sdf.format(time)).getId();// 获取订单id

        Iterator<OrderDetails> it = order.getDetails().iterator();// 获取商品详情
        while (it.hasNext()) {
            OrderDetails orderDetails = it.next();
            // 详情表新增记录：商品种类id、重量
            detailsMapper.insertDetail(orderDetails);
            long did = orderDetails.getId();
            // 订单-详情关联表新增记录：订单id、详情id
            orderDetailsMapper.insertOD(oid, did);
        }
        return true;
    }

    @Override
    public boolean updateStatus(long orderId, int status) {
        return orderMapper.updateStatus(orderId, status);
    }
}
