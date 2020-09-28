package com.appleyk.account.dao.mapper;

import com.appleyk.account.dao.entity.AccountEntity;
import feign.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * <p>账户通用Mapper</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 14:25 2020/9/27
 */
public interface AccountMapper extends Mapper<AccountEntity> {
    Integer decreaseAmount(@Param("entity") AccountEntity account);
}
