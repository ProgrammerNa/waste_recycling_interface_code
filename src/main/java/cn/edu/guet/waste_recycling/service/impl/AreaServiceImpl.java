package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Area;
import cn.edu.guet.waste_recycling.mapper.IAreaMapper;
import cn.edu.guet.waste_recycling.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Area> list = areaMapper.getAreas();
        List<Area> tree = new ArrayList<>();
        for (Area area: list) {
            if (area.getParentId() == 0) {
                tree.add(area);
            }
            List<Area> children = new ArrayList<>();
            for (Area node: list) {
                if (node.getParentId() == area.getId()) {
                    children.add(node);
                }
            }
            if (!children.isEmpty())
                area.setChildren(children);
        }
        return tree;
    }
}
