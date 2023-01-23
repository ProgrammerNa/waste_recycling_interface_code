package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.mapper.IApplicationMapper;
import cn.edu.guet.waste_recycling.mapper.IApplicationPicMapper;
import cn.edu.guet.waste_recycling.mapper.IOrderMapper;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private IApplicationMapper applicationMapper;
    @Autowired
    private IApplicationPicMapper applicationPicMapper;
    @Autowired
    private IOrderMapper orderMapper;

    @Override
    public List<Application> getById(long id) {
        // 1.根据回收员id获取到订单列表
        // 2.把订单列表作为参数传入，取订单id作为索引获取申请列表
        List<Application> list = applicationMapper.getById(orderMapper.getOrdersByRId(id));
        for (Application a: list) {
            long orderId = a.getOrderId();
            a.setPicUrl(applicationPicMapper.getByOrderId(orderId));
        }
        return list;
    }

    @Override
    public boolean submitApplication(Application application) {
        return applicationMapper.submitApplication(application);
    }

    @Override
    public boolean updateStatus(long id, int status) {
        return applicationMapper.updateStatus(id, status);
    }
}
