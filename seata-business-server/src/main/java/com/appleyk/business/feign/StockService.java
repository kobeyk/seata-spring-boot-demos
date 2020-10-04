package com.appleyk.business.feign;

import com.appleyk.common.dto.CommodityDTO;
import com.appleyk.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>商品库存服务远程（feign）接口</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 23:03 2020/9/28
 */
@FeignClient(value = "storage-server")
public interface StockService {

    /**
     * 减库存接口
     * @param commodityDTO 商品数据传输对象
     * @return
     */
    @PostMapping("/stock/reduce")
    ResponseResult reduce(@RequestBody CommodityDTO commodityDTO) throws Exception;

    /**
     * 减库存接口（手动模拟异常，模拟分支事务执行异常时，TM发起全局回滚操作）
     * @param commodityDTO 商品数据传输对象
     * @return
     */
    @PostMapping("/stock/reduce/exception")
    ResponseResult reduce2(@RequestBody CommodityDTO commodityDTO) throws Exception;

    /***
     * 模拟测试商品信息查询
     * @param id 商品id
     * @return
     */
    @GetMapping("/stock/query/{id}")
    ResponseResult query(@PathVariable("id") Long id);

}
