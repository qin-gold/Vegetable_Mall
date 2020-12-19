package com.shop.domain;

import java.io.Serializable;

/**
 * @author qsj
 */
public class ShopCart implements Serializable {
    private Integer sc_id;
    private Integer p_count;
    private Integer u_id;
    private Integer p_id;
    private Product product;

    public Integer getSc_id() {
        return sc_id;
    }

    public void setSc_id(Integer sc_id) {
        this.sc_id = sc_id;
    }

    public Integer getP_count() {
        return p_count;
    }

    public void setP_count(Integer p_count) {
        this.p_count = p_count;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "sc_id=" + sc_id +
                ", p_count=" + p_count +
                ", u_id=" + u_id +
                ", p_id=" + p_id +
                ", product=" + product +
                '}';
    }
}
