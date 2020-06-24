package com.dbb.entity;

public class ElecUsage {
    private Integer id;
    private Integer merchantid;
    private Float cost;
    private Float tipusage;
    private Float tipcost;
    private Float peakusage;
    private Float peakcost;
    private Float valleyusage;
    private Float valleycost;
    private Float flatusage;
    private Float flatcost;
    private Float allusage;
    private Float nowreading;
    private Integer settletime;
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

    public Float getNowreading() {
        return nowreading;
    }

    public void setNowreading(Float nowreading) {
        this.nowreading = nowreading;
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

    public Float getTipusage() {
        return tipusage;
    }

    public void setTipusage(Float tipusage) {
        this.tipusage = tipusage;
    }

    public Float getTipcost() {
        return tipcost;
    }

    public void setTipcost(Float tipcost) {
        this.tipcost = tipcost;
    }

    public Float getPeakusage() {
        return peakusage;
    }

    public void setPeakusage(Float peakusage) {
        this.peakusage = peakusage;
    }

    public Float getPeakcost() {
        return peakcost;
    }

    public void setPeakcost(Float peakcost) {
        this.peakcost = peakcost;
    }

    public Float getValleyusage() {
        return valleyusage;
    }

    public void setValleyusage(Float valleyusage) {
        this.valleyusage = valleyusage;
    }

    public Float getValleycost() {
        return valleycost;
    }

    public void setValleycost(Float valleycost) {
        this.valleycost = valleycost;
    }

    public Float getFlatusage() {
        return flatusage;
    }

    public void setFlatusage(Float flatusage) {
        this.flatusage = flatusage;
    }

    public Float getFlatcost() {
        return flatcost;
    }

    public void setFlatcost(Float flatcost) {
        this.flatcost = flatcost;
    }

    public Float getAllusage() {
        return allusage;
    }

    public void setAllusage(Float allusage) {
        this.allusage = allusage;
    }

    public Integer getSettletime() {
        return settletime;
    }

    public void setSettletime(Integer settletime) {
        this.settletime = settletime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SettleUsage{");
        sb.append("id=").append(id);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", cost=").append(cost);
        sb.append(", tipusage=").append(tipusage);
        sb.append(", tipcost=").append(tipcost);
        sb.append(", peakusage=").append(peakusage);
        sb.append(", peakcost=").append(peakcost);
        sb.append(", valleyusage=").append(valleyusage);
        sb.append(", valleycost=").append(valleycost);
        sb.append(", flatusage=").append(flatusage);
        sb.append(", flatcost=").append(flatcost);
        sb.append(", allusage=").append(allusage);
        sb.append(", settletime=").append(settletime);
        sb.append('}');
        return sb.toString();
    }
}
