package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHS
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/getGoods")
    public HttpResult getGoods() {
        return HttpResult.ok(goodsService.getGoods());
    }

    @GetMapping("/getPriceByName")
    public HttpResult getPriceByName(@RequestParam String name) {
        // 如果获取的是Goods实体类，要注意delFlag不为0时数据无效（已被删除）
        return HttpResult.ok(goodsService.getPriceByName(name));
    }
}
