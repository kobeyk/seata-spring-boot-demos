package com.appleyk.business.service;

import com.appleyk.business.feign.AccountService;
import com.appleyk.business.feign.IntegralService;
import com.appleyk.business.feign.OrderService;
import com.appleyk.business.feign.StockService;
import com.appleyk.common.dto.BusinessDTO;
import com.appleyk.common.dto.OrderDTO;
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

    @GlobalTransactional(timeoutMills = 30000)
    public boolean buy(BusinessDTO businessDTO){
        orderService.create(new OrderDTO(businessDTO));
        return true;
    }

}
