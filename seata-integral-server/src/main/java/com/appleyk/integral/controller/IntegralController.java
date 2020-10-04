package com.appleyk.integral.controller;

import com.appleyk.common.helper.LoggerHelper;
import com.appleyk.common.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>积分接口控制层</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:38 2020/9/28
 */
@CrossOrigin
@RestController
@RequestMapping("/integral")
public class IntegralController {

    @GetMapping("/add/{uid}/{integral}")
    public ResponseResult add(@PathVariable("uid") Long uid,
                              @PathVariable("integral") Integer integral){
        String message = "用户【"+uid+"】成功加了【"+integral+"】积分";
        LoggerHelper.info(message);
        return ResponseResult.ok(message);
    }

}
