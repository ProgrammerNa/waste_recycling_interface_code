package cn.edu.guet.waste_recycling.service;

import cn.edu.guet.waste_recycling.bean.Address;

import java.util.List;

/**
 * @author HHS
 */
public interface IAddressService {
    List<Address> getAddressById(long id);
    boolean addAddressToId(Address address);
}
