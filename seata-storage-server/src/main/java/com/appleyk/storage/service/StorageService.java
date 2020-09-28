package com.appleyk.storage.service;

import com.appleyk.common.dto.CommodityDTO;
import com.appleyk.common.enums.ResultCode;
import com.appleyk.common.exception.CommonException;
import com.appleyk.storage.dao.entity.StockEntity;
import com.appleyk.storage.dao.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:21 2020/9/28
 */
@Service
public class StorageService {

    @Autowired
    private StockMapper stockMapper;

    @Transactional(rollbackFor = {CommonException.class,Exception.class})
    public CommodityDTO reduceStock(CommodityDTO commodityDTO) throws CommonException {
        Integer count = stockMapper.reduceStock(StockEntity.createEntity(commodityDTO));
        if(count>0){
            return commodityDTO;
        }
        throw new CommonException(ResultCode.FAIL,"减库存操作失败！");
    }

}
