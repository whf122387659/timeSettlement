package com.dbb.entity;

public class AllUsage {

    private Integer merchantid;
    private Float allcost;
    private Float allelecusage;
    private Float alleleccost;
    private Float allwaterusage;
    private Float allwatercost;
    private Float allgasusage;
    private Float allgascost;

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Float getAllcost() {
        return allcost;
    }

    public void setAllcost(Float allcost) {
        this.allcost = allcost;
    }

    public Float getAllelecusage() {
        return allelecusage;
    }

    public void setAllelecusage(Float allelecusage) {
        this.allelecusage = allelecusage;
    }

    public Float getAlleleccost() {
        return alleleccost;
    }

    public void setAlleleccost(Float alleleccost) {
        this.alleleccost = alleleccost;
    }

    public Float getAllwaterusage() {
        return allwaterusage;
    }

    public void setAllwaterusage(Float allwaterusage) {
        this.allwaterusage = allwaterusage;
    }

    public Float getAllwatercost() {
        return allwatercost;
    }

    public void setAllwatercost(Float allwatercost) {
        this.allwatercost = allwatercost;
    }

    public Float getAllgasusage() {
        return allgasusage;
    }

    public void setAllgasusage(Float allgasusage) {
        this.allgasusage = allgasusage;
    }

    public Float getAllgascost() {
        return allgascost;
    }

    public void setAllgascost(Float allgascost) {
        this.allgascost = allgascost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AllUsage{");
        sb.append("merchantid=").append(merchantid);
        sb.append(", allcost=").append(allcost);
        sb.append(", allelecusage=").append(allelecusage);
        sb.append(", alleleccost=").append(alleleccost);
        sb.append(", allwaterusage=").append(allwaterusage);
        sb.append(", allwatercost=").append(allwatercost);
        sb.append(", allgasusage=").append(allgasusage);
        sb.append(", allgascost=").append(allgascost);
        sb.append('}');
        return sb.toString();
    }
}
