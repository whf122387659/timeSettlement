package com.dbb.entity;

public class Price {
    private int id;
    private String timeName;
    private String name;
    private String timeprice;
    private String unifyprice;
    private long createtime;
    private int type;
    private int companyid;
    private String time;
    private float waterprice;
    private float gasprice;

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeprice() {
        return timeprice;
    }

    public void setTimeprice(String timeprice) {
        this.timeprice = timeprice;
    }

    public String getUnifyprice() {
        return unifyprice;
    }

    public void setUnifyprice(String unifyprice) {
        this.unifyprice = unifyprice;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getWaterprice() {
        return waterprice;
    }

    public void setWaterprice(float waterprice) {
        this.waterprice = waterprice;
    }

    public float getGasprice() {
        return gasprice;
    }

    public void setGasprice(float gasprice) {
        this.gasprice = gasprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Price{");
        sb.append("id=").append(id);
        sb.append(", timeName='").append(timeName).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", timeprice='").append(timeprice).append('\'');
        sb.append(", unifyprice='").append(unifyprice).append('\'');
        sb.append(", createtime=").append(createtime);
        sb.append(", type=").append(type);
        sb.append(", companyid=").append(companyid);
        sb.append(", time='").append(time).append('\'');
        sb.append(", waterprice=").append(waterprice);
        sb.append(", gasprice=").append(gasprice);
        sb.append('}');
        return sb.toString();
    }
}
