package com.appleyk.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 订单数据传输对象，对应用户的下单操作
 */
public class OrderDTO implements Serializable {

    private String orderNo;

    private Long userId;

    private String commodityCode;

    private Integer orderCount;

    private BigDecimal orderAmount;

    public String getOrderNo() {
        return orderNo;
    }

    public OrderDTO(){

    }

    public OrderDTO(String orderNo, Long userId, String commodityCode, Integer orderCount, BigDecimal orderAmount) {
        this.orderNo = orderNo;
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.orderCount = orderCount;
        this.orderAmount = orderAmount;
    }

    public OrderDTO(BusinessDTO businessDTO){
        this.orderNo = "CN"+System.currentTimeMillis();
        this.userId = businessDTO.getUserId();
        this.commodityCode = businessDTO.getCommodityCode();
        this.orderCount = businessDTO.getCount();
        this.orderAmount = businessDTO.getAmount();
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

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

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", commodityCode='" + commodityCode + '\'' +
                ", orderCount=" + orderCount +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
