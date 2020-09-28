package com.appleyk.order.service;

import com.appleyk.common.dto.OrderDTO;
import com.appleyk.common.enums.ResultCode;
import com.appleyk.common.exception.CommonException;
import com.appleyk.order.dao.entity.OrderEntity;
import com.appleyk.order.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>下单业务操作</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:58 2020/9/28
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = {CommonException.class,Exception.class})
    public OrderDTO createOrder(OrderDTO orderDTO) throws CommonException{
        int count = orderMapper.insert(OrderEntity.createEntity(orderDTO));
        if(count>0){
           return orderDTO;
        }
        throw new CommonException(ResultCode.OK,"创建订单失败！");
    }

}
