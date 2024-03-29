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

    @GetMapping("/getOrdersByRId")
    public HttpResult getOrdersByRId(@RequestParam long id){
        return HttpResult.ok(orderService.getOrdersByRId(id));
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
    public HttpResult updateOrderStatus(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        int status = json.get("status").asInt();
        return HttpResult.ok(orderService.updateStatus(orderId, status));
    }

    @GetMapping("/getAcceptableOrders")
    public HttpResult getAcceptableOrders() {
        return HttpResult.ok(orderService.getAcceptableOrders());
    }

    @PostMapping("/acceptOrderByRec")
    public HttpResult acceptOrderByRec(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        long recyclerId = json.get("recyclerId").asInt();
        return HttpResult.ok(orderService.acceptOrderByRec(orderId, recyclerId));
    }

    @PostMapping("/updateGoodsWeight")
    public HttpResult updateGoodsWeight(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        long goodsId = json.get("goodsId").asInt();
        double weight = json.get("weight").asDouble();
        double ifPrice = json.get("ifPrice").asDouble();
        return HttpResult.ok(orderService.updateGoodsWeightAPrice(orderId, goodsId, weight, ifPrice));
    }

//    @PostMapping("/updateGoodsWeight")
//    public HttpResult updateGoodsWeight(@RequestBody ObjectNode json) {
//        long orderId = json.get("orderId").asInt();
//        long goodsId = json.get("goodsId").asInt();
//        double weight = json.get("weight").asDouble();
//        return HttpResult.ok(orderService.updateGoodsWeight(orderId, goodsId, weight));
//    }

    @PostMapping("/updateCanApplication")//x ?
    public HttpResult updateCanApplication(@RequestBody ObjectNode json) {
        long id = json.get("orderId").asInt();
        int canApplication = json.get("canApplication").asInt();
        return HttpResult.ok(orderService.updateCanApplication(id, canApplication));
    }

    @PostMapping("/updateGoodsPrice")//x
    public HttpResult updateGoodsPrice(@RequestBody ObjectNode json) {
        long orderId = json.get("orderId").asInt();
        long goodsId = json.get("goodsId").asInt();
        double ifPrice = json.get("ifPrice").asDouble();
        return HttpResult.ok(orderService.updateGoodsPrice(orderId, goodsId, ifPrice));
    }

    @PostMapping("/orderStatistics")
    public HttpResult orderStatistics(@RequestBody ObjectNode json) {
        long id = json.get("id").asInt();// 用户id
        String year = json.get("year").asText();// 传参需要统计的年份
        return HttpResult.ok(orderService.orderStatistics(id, year));
    }
}
