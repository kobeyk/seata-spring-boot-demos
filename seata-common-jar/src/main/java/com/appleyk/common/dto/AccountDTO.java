package com.appleyk.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户支付账户中心数据传输对象，对应用户下单后扣款操作
 */
public class AccountDTO implements Serializable {

    private Integer id;

    /**用户标识*/
    private Long userId;

    /**账户余额*/
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
