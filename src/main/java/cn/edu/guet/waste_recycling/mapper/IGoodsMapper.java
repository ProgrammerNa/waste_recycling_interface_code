package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IGoodsMapper {
    List<Goods> getGoods();
    double getPriceByName(String name);
}
