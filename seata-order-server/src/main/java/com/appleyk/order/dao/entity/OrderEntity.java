package com.appleyk.order.dao.entity;

import com.appleyk.common.dto.OrderDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p></p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:48 2020/9/28
 */
@Table(name = "t_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    /**订单编号*/
    public String orderNo;
    /**用户标识*/
    public Long uid;
    /**商品唯一编号*/
    public String commodityCode;
    /**商品数量*/
    public Integer count;
    /**订单金额*/
    public Double amount;

    private OrderEntity(OrderDTO orderDTO){
        this.orderNo = orderDTO.getOrderNo();
        this.uid = orderDTO.getUserId();
        this.commodityCode = orderDTO.getCommodityCode();
        this.count = orderDTO.getOrderCount();
        this.amount = orderDTO.getOrderAmount().doubleValue();
    }

    public static OrderEntity createEntity(OrderDTO orderDTO){
        return new OrderEntity(orderDTO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
