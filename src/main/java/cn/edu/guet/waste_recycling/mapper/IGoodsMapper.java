package cn.edu.guet.waste_recycling.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author HHS
 */
@Mapper
public interface IGoodsMapper {
    double getPriceByName(String name);
}
