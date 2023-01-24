package cn.edu.guet.waste_recycling;

import cn.edu.guet.waste_recycling.bean.Area;
import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.controller.AddressController;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import cn.edu.guet.waste_recycling.service.IAreaService;
import cn.edu.guet.waste_recycling.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class WasteRecyclingApplicationTests {

    @Autowired
    IOrderService orderService;
    @Autowired
    IAreaService areaService;
    @Autowired
    IApplicationService applicationService;

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

    @Test
    public void testAddAddress() {
//        ObjectNode object = new ObjectNode(new JSONObject());
//        object.put("name","1");
//        object.put("phone","1");
//        object.put("areaId",1);
//
//        object.put("userId",2);
//        AddressController a = new AddressController();
//        a.addAddress(object);
    }

    @Test
    public void testGetOrders() {
        orderService.getOrders();
    }

    @Test
    public void testGetOrdersByUId() {
        orderService.getOrdersByUId(18);
    }

    @Test
    public void testGetById() {
        System.out.println(applicationService.getById(1));
    }
}
