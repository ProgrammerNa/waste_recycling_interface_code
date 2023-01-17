package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Goods;
import cn.edu.guet.waste_recycling.mapper.IGoodsMapper;
import cn.edu.guet.waste_recycling.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoods() {
        return goodsMapper.getGoods();
    }

    @Override
    public double getPriceByName(String name) {
        return goodsMapper.getPriceByName(name);
    }
}
