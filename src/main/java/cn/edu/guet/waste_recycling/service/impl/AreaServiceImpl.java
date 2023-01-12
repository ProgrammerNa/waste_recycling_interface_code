package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Area;
import cn.edu.guet.waste_recycling.mapper.IAreaMapper;
import cn.edu.guet.waste_recycling.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 */
@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaMapper areaMapper;

    @Override
    public List<Area> getAreas() {
        return areaMapper.getAreas();
    }
}
