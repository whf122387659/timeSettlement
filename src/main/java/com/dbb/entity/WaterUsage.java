package com.dbb.entity;

public class WaterUsage {
    private Integer id;
    private Integer merchantid;
    private Float cost;
    private Integer settletime;
    private Float allusage;
    private Float nowreading;
    private Float shareusage;
    private Float sharecost;

    public Float getShareusage() {
        return shareusage;
    }

    public void setShareusage(Float shareusage) {
        this.shareusage = shareusage;
    }

    public Float getSharecost() {
        return sharecost;
    }

    public void setSharecost(Float sharecost) {
        this.sharecost = sharecost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getSettletime() {
        return settletime;
    }

    public void setSettletime(Integer settletime) {
        this.settletime = settletime;
    }

    public Float getAllusage() {
        return allusage;
    }

    public void setAllusage(Float allusage) {
        this.allusage = allusage;
    }

    public Float getNowreading() {
        return nowreading;
    }

    public void setNowreading(Float nowreading) {
        this.nowreading = nowreading;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WaterUsage{");
        sb.append("id=").append(id);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", cost=").append(cost);
        sb.append(", settletime=").append(settletime);
        sb.append(", allusage=").append(allusage);
        sb.append(", nowreading=").append(nowreading);
        sb.append(", shareusage=").append(shareusage);
        sb.append(", sharecost=").append(sharecost);
        sb.append('}');
        return sb.toString();
    }
}
