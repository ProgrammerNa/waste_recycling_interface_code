package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class OrderDetails extends BaseModel {
    private long goodsId;
    private double weight;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return goodsId == that.goodsId && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, weight);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "goodsId=" + goodsId +
                ", weight=" + weight +
                '}';
    }
}
