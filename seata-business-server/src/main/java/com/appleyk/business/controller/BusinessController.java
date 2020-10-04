package com.appleyk.business.controller;

import com.appleyk.business.feign.OrderService;
import com.appleyk.business.service.BusinessService;
import com.appleyk.common.dto.BusinessDTO;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <p>电商/商品下单业务操作入口（全局事务的发起者TM）</p>
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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @LoadBalanced
    private RestTemplate loadBalance;

    @Autowired
    private OrderService orderService;

    /**
     *  businessDTO:
     *
     *  {
     *   "userId":1001,
     *   "commodityCode":"C201901140001",
     *   "name":"水杯",
     *   "count":2,
     *   "amount":20.0
     * }
     */

    @PostMapping("/commodity/buy")
    public ResponseResult buy(@RequestBody BusinessDTO businessDTO) throws Exception{
        LoggerHelper.info("商品购买，商品："+businessDTO);
        return ResponseResult.ok(businessService.buy(businessDTO));
    }

    @PostMapping("/commodity/buy/exception")
    public ResponseResult buy2(@RequestBody BusinessDTO businessDTO) throws Exception{
        LoggerHelper.info("商品购买，商品："+businessDTO);
        return ResponseResult.ok(businessService.buy2(businessDTO));
    }

    @GetMapping("/order/query1/{id}")
    public ResponseResult orderQuery1(@PathVariable("id") Long id){
        LoggerHelper.info("RestTemplate实现远程接口的调用(serverAddr:port/url)");
        return restTemplate.getForObject("http://localhost:8022/order/query/"+id, ResponseResult.class);
    }

    @GetMapping("/order/query2/{id}")
    public ResponseResult orderQuery2(@PathVariable("id") Long id){
        LoggerHelper.info("RestTemplate实现远程接口的调用(serverName/url)");
        return loadBalance.getForObject("http://order-server/order/query/"+id, ResponseResult.class);
    }

    @GetMapping("/order/query3/{id}")
    public ResponseResult orderQuery3(@PathVariable("id") Long id){
        LoggerHelper.info("Feign实现远程接口的调用(serverName/url)");
        return orderService.query(id);
    }

}
