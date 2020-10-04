package com.appleyk.storage.service;

import com.appleyk.common.dto.CommodityDTO;
import com.appleyk.common.enums.ResultCode;
import com.appleyk.common.exception.CommonException;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.storage.dao.entity.StockEntity;
import com.appleyk.storage.dao.mapper.StockMapper;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>库存业务实现</p>
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

    /**
     * 商品减库存
     * @param commodityDTO 商品数据传输对象
     * @return CommodityDTO
     * @throws CommonException
     */
    public CommodityDTO reduceStock(CommodityDTO commodityDTO) throws CommonException {
        LoggerHelper.info("全局事务ID = "+ RootContext.getXID());
        Integer count = stockMapper.reduceStock(StockEntity.createEntity(commodityDTO));
        if(count>0){
            return commodityDTO;
        }
        throw new CommonException(ResultCode.FAIL,"减库存操作失败！");
    }

    /**
     * 商品减库存
     * @param commodityDTO  商品数据传输对象
     * @return CommodityDTO
     * @throws CommonException
     */
    public CommodityDTO reduceStock2(CommodityDTO commodityDTO) throws CommonException {
        LoggerHelper.info("全局事务ID = "+ RootContext.getXID());
        Integer count = stockMapper.reduceStock(StockEntity.createEntity(commodityDTO));
        if(count>0){
            // 手动模拟抛异常
            LoggerHelper.info("手动触发异常："+1/0);
            return commodityDTO;
        }
        throw new CommonException(ResultCode.FAIL,"减库存操作失败！");
    }
}
