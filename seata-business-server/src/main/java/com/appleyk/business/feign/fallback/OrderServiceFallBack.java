package com.appleyk.business.feign.fallback;

import com.appleyk.business.feign.OrderService;
import com.appleyk.common.dto.OrderDTO;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * <p>订单服务，降级回调实现</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:22 2020/10/3
 */
@Service
public class OrderServiceFallBack implements OrderService {

    /***
     * 订单创建
     * @param dto 订单数据传输对象
     * @return ResponseResult
     */
    @Override
    public ResponseResult create(OrderDTO dto) throws Exception{
        LoggerHelper.info("订单创建异常,订单信息："+dto);
        return ResponseResult.fail("订单服务繁忙，请稍候再试（言外之意：订单服务要么挂了要么调用失败！！！");
    }

    /**
     * 按订单ID查询订单
     * @param id 订单id
     * @return ResponseResult
     */
    @Override
    public ResponseResult query(Long id) {
        LoggerHelper.info("订单查询异常,订单查询ID："+id);
        return ResponseResult.fail("订单服务繁忙，请稍候再试（言外之意：订单服务要么挂了要么调用失败！！！");
    }
}
