package com.shop.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
public class Description implements Serializable {
    private Integer d_id;
    private String d_remark;
    private List<Product> productList;
    private Product product;

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_remark() {
        return d_remark;
    }

    public void setD_remark(String d_remark) {
        this.d_remark = d_remark;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Description{" +
                "d_id=" + d_id +
                ", d_remark='" + d_remark + '\'' +
                ", productList=" + productList +
                ", product=" + product +
                '}';
    }
}
