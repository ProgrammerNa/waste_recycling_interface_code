package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Application;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HHS
 */
@Mapper
public interface IApplicationMapper {
    boolean submitApplication(Application application);
}
