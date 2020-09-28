package com.appleyk.business.feign;

import com.appleyk.business.feign.fallback.IntegralServiceFallback;
import com.appleyk.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>积分服务远程（feign）接口</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:46 2020/9/28
 */
@FeignClient(value = "integral-server",fallback = IntegralServiceFallback.class)
public interface IntegralService {

    /***
     * 下单成功后，加积分接口
     * @param uid 用户id
     * @param integral 积分
     * @return
     */
    @GetMapping("/integral/add/{uid}/{integral}")
    ResponseResult add(@PathVariable("uid") Long uid,
                       @PathVariable("integral") Integer integral);

}
