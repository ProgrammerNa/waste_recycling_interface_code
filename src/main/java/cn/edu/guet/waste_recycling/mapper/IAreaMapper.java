package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IAreaMapper {
    List<Area> getAreas();
}
