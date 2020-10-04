package com.appleyk.account.controller;

import com.appleyk.account.service.AccountService;
import com.appleyk.common.dto.AccountDTO;
import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>用户个人支付账户中心接口控制层</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 10:52 2020/9/28
 */
@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /***
     * 扣减用户账户金额
     * @param accountDTO 账户数据传输对象
     * @return 响应结果
     */
    @PostMapping("/amount/decrease")
    public ResponseResult decreaseAmount(@RequestBody AccountDTO accountDTO) throws Exception{
        LoggerHelper.info("扣款接口调用，accountDto："+accountDTO);
        return ResponseResult.ok(accountService.decreaseAmount(accountDTO));
    }

    @GetMapping("/query/{uid}")
    public ResponseResult query(@PathVariable("uid") Long uid){
        LoggerHelper.info("账户查询接口调用成功，账户uid = "+uid);
        return ResponseResult.ok("账户uid = "+uid);
    }

}
