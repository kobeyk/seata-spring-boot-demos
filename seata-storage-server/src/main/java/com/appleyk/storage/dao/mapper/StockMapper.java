package com.appleyk.storage.dao.mapper;

import com.appleyk.storage.dao.entity.StockEntity;
import feign.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * <p>库存通用Mapper</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:08 2020/9/28
 */
public interface StockMapper extends Mapper<StockEntity> {
    Integer reduceStock(@Param("entity") StockEntity entity);
}
