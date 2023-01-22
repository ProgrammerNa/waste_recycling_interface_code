package cn.edu.guet.waste_recycling.bean;

/**
 * @author HHS
 */
public class ApplicationPic {
    private long orderId;
    private String picUrl;

    public ApplicationPic() {
    }

    public ApplicationPic(long orderId, String picUrl) {
        this.orderId = orderId;
        this.picUrl = picUrl;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
