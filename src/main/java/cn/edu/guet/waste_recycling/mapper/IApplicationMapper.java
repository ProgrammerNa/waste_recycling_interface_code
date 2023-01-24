package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IApplicationMapper {
    List<Application> getById(long id);
    long getOrderIdById(long id);

    boolean submitApplication(Application application);
    boolean updateStatus(@Param(value = "id") long id, @Param(value = "status") int status);
}
