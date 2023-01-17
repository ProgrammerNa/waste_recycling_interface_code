package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Goods;

import java.util.List;

/**
 * @author HHS
 */
public interface IGoodsService {
    List<Goods> getGoods();
    double getPriceByName(String name);
}
