package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.mapper.IApplicationMapper;
import cn.edu.guet.waste_recycling.mapper.IApplicationPicMapper;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Application> getById(long id) {
        List<Application> list = applicationMapper.getById(id);
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
