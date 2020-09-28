package com.appleyk.business.controller;

import com.appleyk.business.feign.OrderService;
import com.appleyk.business.service.BusinessService;
import com.appleyk.common.dto.BusinessDTO;
import com.appleyk.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <p></p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 16:26 2020/9/25
 */
@CrossOrigin
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseResult buy(@RequestBody BusinessDTO businessDTO){
        return ResponseResult.ok(businessService.buy(businessDTO));
    }

    @GetMapping("/order/query1/{id}")
    public ResponseResult orderQuery1(@PathVariable("id") Long id){
        return this.restTemplate.getForObject("http://127.0.0.1:8021/order/query/"+id, ResponseResult.class);
    }

    @GetMapping("/order/query2/{id}")
    public ResponseResult orderQuery2(@PathVariable("id") Long id){
        return orderService.query(id);
    }
}
