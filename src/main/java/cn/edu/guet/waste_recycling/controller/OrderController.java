package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IOrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author HHS
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getOrders")
    public HttpResult getOrders(){
        return HttpResult.ok(orderService.getOrders());
    }

    @GetMapping("/getOrdersByUId")
    public HttpResult getOrdersByUId(@RequestParam long id){
        return HttpResult.ok(orderService.getOrdersByUId(id));
    }

    @PostMapping("/addOrder")
    public HttpResult addOrder(@RequestBody ObjectNode json) {
        long userId = json.get("userId").asInt();
        String bookDate = json.get("bookDate").asText();
        long addressId = json.get("addressId").asInt();
//        System.out.println("@@@@@@@@@@@@@@@@@@@@"+bookDate);

        Iterator<JsonNode> it = json.get("details").iterator();// 用迭代器遍历嵌套内部的json
        List<OrderDetails> details = new ArrayList<>();
        while (it.hasNext()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setGoodsId(it.next().asInt());
            orderDetails.setWeight(it.next().asDouble());
            details.add(orderDetails);
        }
        return HttpResult.ok(orderService.insertOrder(new Order(userId, bookDate, addressId, details)));
    }

    @PostMapping("/updateOrderStatus")
    public HttpResult updateOrder(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        int status = json.get("status").asInt();
        return HttpResult.ok(orderService.updateStatus(orderId, status));
    }
}
