package com.appleyk.account.service;

import com.appleyk.account.dao.entity.AccountEntity;
import com.appleyk.account.dao.mapper.AccountMapper;
import com.appleyk.common.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>用户支付中心业务层操作实现</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 14:26 2020/9/27
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    public boolean decreaseAmount(AccountDTO accountDTO){
        return accountMapper.decreaseAmount(AccountEntity.createEntity(accountDTO)) > 0;
    }

}
