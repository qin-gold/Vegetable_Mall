package com.shop.domain;

import java.io.Serializable;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
public class OrderDetails implements Serializable {
    private String od_id;
    private int p_id;
    private int od_count;
    private Product product;

    public String getOd_id() {
        return od_id;
    }

    public void setOd_id(String od_id) {
        this.od_id = od_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getOd_count() {
        return od_count;
    }

    public void setOd_count(int od_count) {
        this.od_count = od_count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "od_id='" + od_id + '\'' +
                ", p_id=" + p_id +
                ", od_count=" + od_count +
                ", product=" + product +
                '}';
    }
}
