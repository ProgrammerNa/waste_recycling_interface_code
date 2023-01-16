package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class Goods extends BaseModel {
    private String name;
    private double price;
    private int delFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        Goods goods = (Goods) o;
        return Double.compare(goods.price, price) == 0 && delFlag == goods.delFlag && Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, delFlag);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", delFlag=" + delFlag +
                '}';
    }
}
