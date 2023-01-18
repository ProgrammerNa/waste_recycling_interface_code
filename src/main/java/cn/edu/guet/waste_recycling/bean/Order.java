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
    private String bookDate;
    private Date date;
    private long addressId;
    private List<OrderDetails> details;
    private int delFlag;
    private Address address;
    private String goodsName;

    public Order() {
    }

    public Order(long userId, String bookDate, Date date, long addressId) {
        this.userId = userId;
        this.bookDate = bookDate;
        this.date = date;
        this.addressId = addressId;
    }

    public Order(long userId, String bookDate, long addressId, List<OrderDetails> details) {
        this.userId = userId;
        this.bookDate = bookDate;
        this.addressId = addressId;
        this.details = details;
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

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public List<OrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetails> details) {
        this.details = details;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return userId == order.userId && recyclerId == order.recyclerId && status == order.status && addressId == order.addressId && delFlag == order.delFlag && Objects.equals(bookDate, order.bookDate) && Objects.equals(date, order.date) && Objects.equals(details, order.details) && Objects.equals(address, order.address) && Objects.equals(goodsName, order.goodsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, recyclerId, status, bookDate, date, addressId, details, delFlag, address, goodsName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", recyclerId=" + recyclerId +
                ", status=" + status +
                ", bookDate='" + bookDate + '\'' +
                ", date=" + date +
                ", addressId=" + addressId +
                ", details=" + details +
                ", delFlag=" + delFlag +
                ", address=" + address +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
