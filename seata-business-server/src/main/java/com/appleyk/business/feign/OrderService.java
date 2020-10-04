package com.appleyk.business.feign;

import com.appleyk.business.feign.fallback.OrderServiceFallBack;
import com.appleyk.common.dto.OrderDTO;
import com.appleyk.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>订单远程调用接口，feign组件，调用远程接口就像调用本地接口一样方便</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:30 2020/9/28
 */
@FeignClient(value = "order-server",fallback = OrderServiceFallBack.class)
public interface OrderService {

    /**
     * 创建订单接口
     * @param dto 订单数据传输对象
     * @return
     */
    @PostMapping(value = "/order/create")
    ResponseResult create(@RequestBody OrderDTO dto) throws Exception;

    /**
     * 模拟订单查询
     * @param id 订单id
     * @return
     */
    @GetMapping("/order/query/{id}")
    ResponseResult query(@PathVariable("id") Long id);
}
