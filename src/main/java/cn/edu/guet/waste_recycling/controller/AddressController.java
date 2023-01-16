package cn.edu.guet.waste_recycling.controller;

import cn.edu.guet.waste_recycling.bean.Address;
import cn.edu.guet.waste_recycling.http.HttpResult;
import cn.edu.guet.waste_recycling.service.IAddressService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HHS
 */
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping("/getAddress")
    public HttpResult getAddress(@RequestParam long id) {
        return HttpResult.ok(addressService.getAddressById(id));
    }

    @PostMapping("/addAddress")
    public HttpResult addAddress(@RequestBody ObjectNode json) {
        String name = json.get("name").asText();
        String phone = json.get("phone").asText();
        long areaId = json.get("areaId").asInt();
        String fullAddress = json.get("fullAddress").asText();
        long userId = json.get("userId").asInt();
        return HttpResult.ok(addressService.addAddressToId(new Address(name, phone, areaId, fullAddress, userId)));
    }
}
