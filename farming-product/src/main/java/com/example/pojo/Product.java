package com.example.pojo;

/**
 * @Author: Cao
 * @Description: 农产品
 * @Date: 2020/9/11
 **/
public class Product {

    private Integer id;

    private String product_name;

    public Product(Integer id, String product_name) {
        this.id = id;
        this.product_name = product_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
