package cn.edu.guet.waste_recycling.bean;

import java.util.Objects;

/**
 * @author HHS
 */
public class Application extends BaseModel {
    private long orderId;
    private int expenses;
    private String evidence;
    private String picUrl;
    private long auditorId;
    private int status;
    private int isApprove;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(long auditorId) {
        this.auditorId = auditorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return orderId == that.orderId && expenses == that.expenses && auditorId == that.auditorId && status == that.status && isApprove == that.isApprove && Objects.equals(evidence, that.evidence) && Objects.equals(picUrl, that.picUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, expenses, evidence, picUrl, auditorId, status, isApprove);
    }

    @Override
    public String toString() {
        return "Application{" +
                "orderId=" + orderId +
                ", expenses=" + expenses +
                ", evidence='" + evidence + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", auditorId=" + auditorId +
                ", status=" + status +
                ", isApprove=" + isApprove +
                '}';
    }
}
