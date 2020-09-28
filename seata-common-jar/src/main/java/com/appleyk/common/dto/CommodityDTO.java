package com.appleyk.common.dto;

import java.io.Serializable;

/**
 * 商品数据传输对象，对应商品的库存操作
 */
public class CommodityDTO implements Serializable {

    private Integer id;

    /**商品唯一编码*/
    private String commodityCode;

    /**商品名称*/
    private String name;

    /**商品数量*/
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
