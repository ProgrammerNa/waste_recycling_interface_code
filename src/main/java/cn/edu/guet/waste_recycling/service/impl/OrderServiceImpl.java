package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.mapper.*;
import cn.edu.guet.waste_recycling.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private IUserRoleMapper userRoleMapper;
    @Autowired
    private IGoodsMapper goodsMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public List<Order> getOrdersByUId(long id) {
        return orderMapper.getOrdersByUId(id);
    }

    @Override
    public List<Order> getOrdersByRId(long id) {
        return orderMapper.getOrdersByRId(id);
    }

    @Override
    public List<Order> getAcceptableOrders() {
        return orderMapper.getAcceptableOrders();
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean insertOrder(Order order) {// 用户下单
        // 其实可以直接原始数据插入而不格式化，因为取出来似乎也还要重新处理？
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

    @Override
    public boolean acceptOrderByRec(long orderId, long recyclerId) {
        return orderMapper.acceptOrderByRec(orderId, recyclerId);
    }

    @Override
    public boolean updateGoodsWeight(long orderId, long goodsId, double weight) {
        long id = detailsMapper.findId(orderId, goodsId);
        return detailsMapper.updateGoodsWeight(id, weight);
    }

    @Override
    public boolean updateGoodsPrice(long orderId, long goodsId, double ifPrice) {
        long id = detailsMapper.findId(orderId, goodsId);
        return detailsMapper.updateGoodsPrice(id, ifPrice);
    }

    @Override
    public boolean updateGoodsWeightAPrice(long orderId, long goodsId, double weight, double ifPrice) {
        long id = detailsMapper.findId(orderId, goodsId);
        return detailsMapper.updateGoodsWeightAPrice(id, weight, ifPrice);
    }


    @Override
    public boolean updateCanApplication(long id, int canApplication) {
        return orderMapper.updateCanApplication(id, canApplication);
    }

    @Override
    public Map<String, List<Double>> orderStatistics(long id, String year) {
        List<Order> list = orderMapper.getOrderStatistics(id, year);// 某年已完成的订单id和时间统计
        int len = list.size();
        List<String> dateList = new ArrayList<>();

        // 将月份数据都处理成yyyy-mm的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (int i = 0;i < len;i++) {
            String date = sdf.format(list.get(i).getDate());
            dateList.add(date);
        }

        long rid = userRoleMapper.findRoleByUId(id);
        double profit = 0;
        double firstProfit = 0;
        // 计算第一个的profit
        if (rid == 2) {// 回收员收益=本月接单数x佣金（每单10）
            firstProfit = 10;
        } else if (rid == 3) {// 普通用户收益=本月下单商品获利
            firstProfit = computeUserProfit(list.get(0).getId());
        }

        List<Double> totalList = new ArrayList<>();// 月份对应的总订单量和收益
        Map<String, List<Double>> map = new HashMap<>();// 月份及月份对应的统计数据
        if (len == 1) {
            totalList.add(1.0);
            totalList.add(firstProfit);
            map.put(dateList.get(0), totalList);
        }

        for (int i = 1, count = 1;i < len; i++) {
            String stemp = dateList.get(i - 1);// 这里的dateList可以全部换成从list中取然后处理数据***

            // 问题：计算了第一个以后，此处会被覆盖
            // 根据不同用户类型 计算收益
            if (rid == 2) {// 回收员收益=本月接单数x佣金（每单10）
                profit += 10;
            }
            else if (rid == 3) {// 普通用户收益=本月下单商品获利
                // 要根据count决定遍历次数，即对应本月每一单的收益
                // 依次从list里取oid传参
                profit += computeUserProfit(list.get(i).getId());
            }

            // 计算单量，存数据
            if (!dateList.get(i).equals(stemp)) {
                totalList.add(Double.valueOf(count));
                if (i == 1) {
                    totalList.add(firstProfit);
                }
                else {
                    totalList.add(profit);
                }
                map.put(stemp, totalList);

                totalList = new ArrayList<>();
                count = 1;
                profit = 0;//*****
            }
            else {
                count++;
            }

            // 最后一个元素的情况：如果不同，此时已经把前加入，需要加自身 count=1；如果同，此时把count加入
            if (i == len - 1) {
                if (!dateList.get(i).equals(stemp)) {
                    totalList.add(1.0);
                }
                else {
                    totalList.add(Double.valueOf(count));
                }

                if (i == 1)
                    totalList.add(firstProfit);
                else {
                    if (rid == 2) {// 回收员收益=本月接单数x佣金（每单10）
                        profit = 10;
                    }
                    else if (rid == 3) {// 普通用户收益=本月下单商品获利
                        // 要根据count决定遍历次数，即对应本月每一单的收益
                        // 依次从list里取oid传参
                        profit = computeUserProfit(list.get(i).getId());
                    }
                    totalList.add(profit);
                }

                map.put(dateList.get(i), totalList);
            }
        }

        return map;
    }

    @Override
    public double computeUserProfit(long oid) {// 计算普通用户本单商品获利
        double profit = 0;

        long did = orderDetailsMapper.getDidByOid(oid);
        // 按理来说此处可能获得许多个商品/did（List），再遍历一个个获取商品信息
        OrderDetails orderDetails = detailsMapper.findDetailsByDId(did);
        double ifPrice = orderDetails.getIfPrice();
        double weight = orderDetails.getWeight();
        if (ifPrice != 0) {// 数据库里为null，取出是0吗？******
            profit = ifPrice * weight;
        }
        else {
            profit = goodsMapper.getPriceById(orderDetails.getGoodsId()) * weight;
        }
        return profit;
    }
}
