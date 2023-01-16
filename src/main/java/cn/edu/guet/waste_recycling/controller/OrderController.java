package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Order;
import cn.edu.guet.waste_recycling.bean.OrderDetails;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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

    @PostMapping("/addOrder")
    public HttpResult addOrder(@RequestBody ObjectNode json) {
        long userId = json.get("userId").asInt();
        String bookDate = json.get("bookDate").asText();
        long addressId = json.get("addressId").asInt();

        ObjectMapper mapper = new ObjectMapper();
        List<OrderDetails> details = new ArrayList<>();
        try {
            details = mapper.readerFor(new TypeReference<List<OrderDetails>>() {}).readValue(json.get("details"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HttpResult.ok(orderService.insertOrder(new Order(userId, bookDate, addressId, details)));
    }
}
