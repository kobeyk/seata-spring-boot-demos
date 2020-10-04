package com.appleyk.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务数据传输对象，整个电商购买商品下单的总（操作）入口
 */
public class BusinessDTO implements Serializable {

    /**用户标识*/
    private Long userId;

    /**商品编号*/
    private String commodityCode;

    /**商品名称*/
    private String name;

    /**商品数量*/
    private Integer count;

    /**订单金额*/
    private BigDecimal amount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BusinessDTO{" +
                "userId=" + userId +
                ", commodityCode='" + commodityCode + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
