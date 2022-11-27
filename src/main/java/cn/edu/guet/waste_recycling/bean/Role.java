package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class Role extends BaseModel {

    private String name;
    private String remark;
    private int delFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return delFlag == role.delFlag && Objects.equals(name, role.name) && Objects.equals(remark, role.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, remark, delFlag);
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
