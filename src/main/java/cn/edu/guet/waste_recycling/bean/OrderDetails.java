package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class OrderDetails extends BaseModel {
    private long goodsId;
    private double weight;
    private double ifPrice;

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getIfPrice() {
        return ifPrice;
    }

    public void setIfPrice(double ifPrice) {
        this.ifPrice = ifPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return goodsId == that.goodsId && Double.compare(that.weight, weight) == 0 && Double.compare(that.ifPrice, ifPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, weight, ifPrice);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "goodsId=" + goodsId +
                ", weight=" + weight +
                ", ifPrice=" + ifPrice +
                '}';
    }
}
