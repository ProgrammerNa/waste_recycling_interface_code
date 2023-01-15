package cn.edu.guet.waste_recycling.bean;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author HHS
 */
public class Order extends BaseModel {
    private long userId;
    private long recyclerId;
    private int status;
    private Date date;
    private List<OrderDetails> details;

    public Order() {
    }

    public Order(long userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRecyclerId() {
        return recyclerId;
    }

    public void setRecyclerId(long recyclerId) {
        this.recyclerId = recyclerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetails> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return userId == order.userId && recyclerId == order.recyclerId && status == order.status && Objects.equals(date, order.date) && Objects.equals(details, order.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, recyclerId, status, date, details);
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", recyclerId=" + recyclerId +
                ", status=" + status +
                ", date=" + date +
                ", details=" + details +
                '}';
    }
}
