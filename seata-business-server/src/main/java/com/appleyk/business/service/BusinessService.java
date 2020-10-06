package com.appleyk.business.service;

import com.appleyk.business.feign.AccountService;
import com.appleyk.business.feign.IntegralService;
import com.appleyk.business.feign.OrderService;
import com.appleyk.business.feign.StockService;
import com.appleyk.common.dto.AccountDTO;
import com.appleyk.common.dto.BusinessDTO;
import com.appleyk.common.dto.CommodityDTO;
import com.appleyk.common.dto.OrderDTO;
import com.appleyk.common.exception.CommonException;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>用户购买商品下单业务操作入口</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:34 2020/9/28
 */
@Service
public class BusinessService {

    /**订单*/
    @Autowired
    private OrderService orderService;

    /**库存*/
    @Autowired
    private StockService stockService;

    /**账户*/
    @Autowired
    private AccountService accountService;

    /**积分*/
    @Autowired
    private IntegralService integralService;

    @GlobalTransactional(timeoutMills = 30000,name = "product-transaction-sample",
    rollbackFor = {CommonException.class,Exception.class})
    public boolean buy(BusinessDTO businessDTO) throws Exception{
        LoggerHelper.info("开始全局事务，XID = " + RootContext.getXID());
        // 1.创建订单
        ResponseResult result = orderService.create(new OrderDTO(businessDTO));
        if(result.getStatus() != 200){
            throw new CommonException("订单创建失败，message："+result.getData());
        }
        // 2.账户扣款
        try{
            result = accountService.decreaseAmount(new AccountDTO(businessDTO));
            if(result.getStatus() != 200){
                throw new CommonException("账户扣款失败，message："+result.getData());
            }
        }catch (Exception e){
            throw new CommonException("账户扣款失败，message："+e.getMessage());
        }

        // 3.增加积分，这里采用了，100积分兑换10积分的策略
        integralService.add(businessDTO.getUserId(),(businessDTO.getAmount().intValue()/10));
        // 4.消减库存
        stockService.reduce(new CommodityDTO(businessDTO));
        return true;
    }

    @GlobalTransactional(timeoutMills = 30000,name = "product-transaction-proxy",
            rollbackFor = {Exception.class})
    public boolean buy2(BusinessDTO businessDTO) throws Exception{
        LoggerHelper.info("开始全局事务，XID = " + RootContext.getXID());
        // 1.创建订单
        ResponseResult orderResult = orderService.create(new OrderDTO(businessDTO));
        if(orderResult.getStatus() != 200){
            throw new CommonException("订单创建失败，message："+orderResult.getMessage());
        }
        // 2.账户扣款
        accountService.decreaseAmount(new AccountDTO(businessDTO));
        // 3.增加积分，这里采用了，100积分兑换10积分的策略
        integralService.add(businessDTO.getUserId(),(businessDTO.getAmount().intValue()/10));
        // 4.消减库存
        stockService.reduce2(new CommodityDTO(businessDTO));
        return true;
    }
}
