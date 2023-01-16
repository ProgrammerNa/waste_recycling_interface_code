package cn.edu.guet.waste_recycling.service.impl;

import cn.edu.guet.waste_recycling.bean.Address;
import cn.edu.guet.waste_recycling.mapper.IAddressMapper;
import cn.edu.guet.waste_recycling.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressMapper addressMapper;

    @Override
    public List<Address> getAddressById(long id) {
        return addressMapper.getAddressById(id);
    }

    @Override
    public boolean addAddressToId(Address address) {
        return addressMapper.addAddressToId(address);
    }
}
