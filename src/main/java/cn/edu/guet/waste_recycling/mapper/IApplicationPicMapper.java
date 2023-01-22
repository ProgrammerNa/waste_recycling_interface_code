package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.ApplicationPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IApplicationPicMapper {
    List<ApplicationPic> getByOrderId(long id);
    boolean insertPic(List<ApplicationPic> list);
}
