package cn.edu.guet.waste_recycling;

import cn.edu.guet.waste_recycling.bean.Area;
import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.service.IAreaService;
import cn.edu.guet.waste_recycling.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class WasteRecyclingApplicationTests {

    @Autowired
    IOrderService orderService;
    @Autowired
    IAreaService areaService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertOrder() {
        List<OrderDetails> list = new ArrayList<>();
//        list.add(new OrderDetails(1,15));
//        list.add(new OrderDetails(2,20));
//        orderService.insertOrder(new Order(1,1,list));
//        System.out.println(order.toString());
    }

    @Test
    public void testSelectArea() {
        List<Area> list = areaService.getAreas();
        for (Area area: list) {
            System.out.println(area.toString());
        }
    }

}
