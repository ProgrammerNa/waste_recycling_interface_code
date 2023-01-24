package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Area;

import java.util.List;

/**
 * @author HHS
 */
public interface IAreaService {
    List<Area> getAreas();
    List<Area> getAreaTree();
}
