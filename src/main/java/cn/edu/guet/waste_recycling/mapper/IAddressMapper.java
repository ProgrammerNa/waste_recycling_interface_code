package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 */
@Mapper
public interface IAddressMapper {
    List<Address> getAddressById(long id);
    boolean updateAddressByAId(Address address);
    boolean addAddressToId(Address address);
}
