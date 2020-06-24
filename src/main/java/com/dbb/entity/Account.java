package com.dbb.entity;

public class Account {
    private int id;
    private String name;
    private String collectors;
    private float beforereading;
    private int merchantid;
    private float nowreading;
    private long time;
    private float cost;
    private float usagepower;
    private String readingString;
    private int powertype;

    public String getReadingString() {
        return readingString;
    }

    public void setReadingString(String readingString) {
        this.readingString = readingString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollectors() {
        return collectors;
    }

    public void setCollectors(String collectors) {
        this.collectors = collectors;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getBeforereading() {
        return beforereading;
    }

    public void setBeforereading(float beforereading) {
        this.beforereading = beforereading;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    public float getNowreading() {
        return nowreading;
    }

    public void setNowreading(float nowreading) {
        this.nowreading = nowreading;
    }

    public float getUsagepower() {
        return usagepower;
    }

    public void setUsagepower(float usagepower) {
        this.usagepower = usagepower;
    }

    public int getPowertype() {
        return powertype;
    }

    public void setPowertype(int powertype) {
        this.powertype = powertype;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", collectors='").append(collectors).append('\'');
        sb.append(", beforereading=").append(beforereading);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", nowreading=").append(nowreading);
        sb.append(", time=").append(time);
        sb.append(", cost=").append(cost);
        sb.append(", usagepower=").append(usagepower);
        sb.append(", readingString='").append(readingString).append('\'');
        sb.append(", powertype=").append(powertype);
        sb.append('}');
        return sb.toString();
    }
}
