package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class Address extends BaseModel {
    private String name;
    private String phone;
    private String areaName;
    private String fullAddress;
    private int isDefault;
    private long userId;

    public Address() {
    }

    public Address(String name, String phone, String areaName, String fullAddress, long userId) {
        this.name = name;
        this.phone = phone;
        this.areaName = areaName;
        this.fullAddress = fullAddress;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return areaName == address.areaName && isDefault == address.isDefault && userId == address.userId && Objects.equals(name, address.name) && Objects.equals(phone, address.phone) && Objects.equals(fullAddress, address.fullAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, areaName, fullAddress, isDefault, userId);
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", areaId=" + areaName +
                ", fullAddress='" + fullAddress + '\'' +
                ", isDefault=" + isDefault +
                ", userId=" + userId +
                '}';
    }
}
