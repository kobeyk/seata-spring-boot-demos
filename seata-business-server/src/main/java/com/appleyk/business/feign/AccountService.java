package com.appleyk.business.feign;

import com.appleyk.common.dto.AccountDTO;
import com.appleyk.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>用户账户服务远程（feign）接口</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:57 2020/9/28
 */
@FeignClient(value = "account-server")
public interface AccountService {

    /**
     * 扣款接口
     * @param accountDTO 账户数据传输对象
     * @return
     */
    @PostMapping("/account/amount/decrease")
    ResponseResult decreaseAmount(@RequestBody AccountDTO accountDTO) throws Exception;

    /**
     * 模拟账户查询
     * @param uid 账户对应的用户id
     * @return
     */
    @GetMapping("/account/query/{uid}")
    ResponseResult query(@PathVariable("uid") Long uid);


}
