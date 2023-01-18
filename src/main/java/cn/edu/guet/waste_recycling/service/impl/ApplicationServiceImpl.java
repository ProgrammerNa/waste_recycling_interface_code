package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Application;
import cn.edu.guet.waste_recycling.mapper.IApplicationMapper;
import cn.edu.guet.waste_recycling.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HHS
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private IApplicationMapper applicationMapper;

    @Override
    public boolean submitApplication(Application application) {
        return applicationMapper.submitApplication(application);
    }
}
