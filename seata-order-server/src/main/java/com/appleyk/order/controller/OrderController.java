package com.appleyk.order.controller;

import com.appleyk.common.dto.OrderDTO;
import com.appleyk.common.response.ResponseResult;
import com.appleyk.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>订单接口控制层</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:47 2020/9/28
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseResult createOrder   (@RequestBody OrderDTO orderDTO) throws Exception{
        return ResponseResult.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/query/{id}")
    public ResponseResult query(@PathVariable("id") Long id){
        System.out.println("订单查询接口调用成功，订单id = "+id);
        return ResponseResult.ok("订单id = "+id);
    }

}
