package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Application;

import java.util.List;

/**
 * @author HHS
 */
public interface IApplicationService {
    List<Application> getById(long id);

    boolean submitApplication(Application application);
    boolean updateStatus(long id, int status);
}
