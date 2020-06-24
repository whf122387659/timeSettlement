package com.dbb.entity;

/**
 * 开户信息
 */
public class Merchant {

    private int id;
    private int companyid;//所属公司id
    private String name;//用户名称
    private String pwd;
    private String phone;//联系电话
    private String mail;//邮箱
    private String addr;//地址
    private String idcard;//身份证号
    private String phone2;//第二联系电话
    private String phone3;//第三联系电话
    private int state;//状态，1表示启用，0表示未启用，-1表示注销
    private float balance;//账户余额
    private long accesstime;//商户接入时间
    private float square;//商户面积
    private String meters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public long getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(long accesstime) {
        this.accesstime = accesstime;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Merchant{");
        sb.append("id=").append(id);
        sb.append(", companyid=").append(companyid);
        sb.append(", name='").append(name).append('\'');
        sb.append(", pwd='").append(pwd).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append(", addr='").append(addr).append('\'');
        sb.append(", idcard='").append(idcard).append('\'');
        sb.append(", phone2='").append(phone2).append('\'');
        sb.append(", phone3='").append(phone3).append('\'');
        sb.append(", state=").append(state);
        sb.append(", balance=").append(balance);
        sb.append(", accesstime=").append(accesstime);
        sb.append(", square=").append(square);
        sb.append(", meters='").append(meters).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
