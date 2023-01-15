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
        orderMapper.insertOrder(new Order(order.getUserId(),time));
//        orderMapper.insertOrder(new Order(1,1,time));
        long oid = orderMapper.getOrderByDate(sdf.format(time)).getId();

        Iterator<OrderDetails> it = order.getDetails().iterator();
        while (it.hasNext()) {
            OrderDetails orderDetails = it.next();
            detailsMapper.insertDetail(orderDetails);
            long did = orderDetails.getId();
            orderDetailsMapper.insertOD(oid, did);
        }
        return true;
    }
}
