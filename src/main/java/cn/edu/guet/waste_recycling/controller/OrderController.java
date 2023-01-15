package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addOrder")
    public HttpResult addOrder(@RequestBody Order order) {
        return HttpResult.ok(orderService.insertOrder(order));
    }
}
