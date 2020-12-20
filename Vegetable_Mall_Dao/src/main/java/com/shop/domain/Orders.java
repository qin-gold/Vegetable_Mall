package com.shop.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
public class Orders implements Serializable {
    private String o_id;
    private String u_id;
    private float totalmoney;
    private String username;
    private String address;
    private String telephone;
    private int paystate;
    private int Destate;
    private int state;
    private Timestamp create_time;
    private List<OrderDetails> orderDetailsList;

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPaystate() {
        return paystate;
    }

    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }

    public int getDestate() {
        return Destate;
    }

    public void setDestate(int destate) {
        Destate = destate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "o_id='" + o_id + '\'' +
                ", u_id=" + u_id +
                ", totalmoney=" + totalmoney +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", paystate=" + paystate +
                ", Destate=" + Destate +
                ", state=" + state +
                ", create_time=" + create_time +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}
