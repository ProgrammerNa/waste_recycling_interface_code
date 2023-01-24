package cn.edu.guet.waste_recycling.bean;

import java.util.List;
import java.util.Objects;

/**
 * @author HHS
 */
public class Application extends BaseModel {
    private long orderId;
    private double expenses;
    private String evidence;
    private int status;
    private int isApprove;
    private List<ApplicationPic> picUrl;
    private int canAdd;

    public Application() {
    }

    public Application(long orderId, double expenses, String evidence) {
        this.orderId = orderId;
        this.expenses = expenses;
        this.evidence = evidence;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }

    public List<ApplicationPic> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<ApplicationPic> picUrl) {
        this.picUrl = picUrl;
    }

    public int getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(int canAdd) {
        this.canAdd = canAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return orderId == that.orderId && Double.compare(that.expenses, expenses) == 0 && status == that.status && isApprove == that.isApprove && canAdd == that.canAdd && Objects.equals(evidence, that.evidence) && Objects.equals(picUrl, that.picUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, expenses, evidence, status, isApprove, picUrl, canAdd);
    }

    @Override
    public String toString() {
        return "Application{" +
                "orderId=" + orderId +
                ", expenses=" + expenses +
                ", evidence='" + evidence + '\'' +
                ", status=" + status +
                ", isApprove=" + isApprove +
                ", picUrl=" + picUrl +
                ", canAdd=" + canAdd +
                '}';
    }
}
