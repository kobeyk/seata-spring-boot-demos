package com.appleyk.account.dao.entity;

import com.appleyk.common.dto.AccountDTO;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>用户支付账户数据实体</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 14:25 2020/9/27
 */
@Table(name = "t_account")
public class AccountEntity {

    @Id
    private Integer id;
    private Long uid;
    private Double amount;

    private AccountEntity(AccountDTO dto){
        this.uid = dto.getUserId();
        this.amount = dto.getAmount().doubleValue();
    }

    public static AccountEntity createEntity(AccountDTO accountDTO){
        return new AccountEntity(accountDTO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
