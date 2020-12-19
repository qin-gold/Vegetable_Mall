package com.shop.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
public class Product implements Serializable {
    private Integer p_id;
    private String p_name;
    private float p_price;
    private Timestamp p_date;
    private Integer p_inventory;
    private String p_overview;
    private Integer d_id;
    private String p_image;
    private Integer p_state;
    private Integer p_isHot;
    private Description description ;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public float getP_price() {
        return p_price;
    }

    public void setP_price(float p_price) {
        this.p_price = p_price;
    }

    public Timestamp getP_date() {
        return p_date;
    }

    public void setP_date(Timestamp p_date) {
        this.p_date = p_date;
    }

    public Integer getP_inventory() {
        return p_inventory;
    }

    public void setP_inventory(Integer p_inventory) {
        this.p_inventory = p_inventory;
    }

    public String getP_overview() {
        return p_overview;
    }

    public void setP_overview(String p_overview) {
        this.p_overview = p_overview;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public Integer getP_state() {
        return p_state;
    }

    public void setP_state(Integer p_state) {
        this.p_state = p_state;
    }

    public Integer getP_isHot() {
        return p_isHot;
    }

    public void setP_isHot(Integer p_isHot) {
        this.p_isHot = p_isHot;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_price=" + p_price +
                ", p_date=" + p_date +
                ", p_inventory=" + p_inventory +
                ", p_overview='" + p_overview + '\'' +
                ", d_id=" + d_id +
                ", p_image='" + p_image + '\'' +
                ", p_state=" + p_state +
                ", p_isHot='" + p_isHot + '\'' +
                ", description=" + description +
                '}';
    }
}
