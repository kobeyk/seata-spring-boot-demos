package com.appleyk.storage.controller;

import com.appleyk.common.dto.CommodityDTO;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import com.appleyk.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>商品库存接口控制层</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:24 2020/9/28
 */
@CrossOrigin
@RestController
@RequestMapping("/stock")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/reduce")
    public ResponseResult reduceStock(@RequestBody CommodityDTO commodityDTO) throws Exception{
        return ResponseResult.ok(storageService.reduceStock(commodityDTO));
    }

    @PostMapping("/reduce/exception")
    public ResponseResult reduceStock2(@RequestBody CommodityDTO commodityDTO) throws Exception{
        return ResponseResult.ok(storageService.reduceStock2(commodityDTO));
    }


    @GetMapping("/query/{id}")
    public ResponseResult query(@PathVariable("id") Long id){
        LoggerHelper.info("商品查询接口调用成功，商品id = "+id);
        return ResponseResult.ok("商品id = "+id);
    }

}
