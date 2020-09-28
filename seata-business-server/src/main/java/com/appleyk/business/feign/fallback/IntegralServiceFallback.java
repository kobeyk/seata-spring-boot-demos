package com.appleyk.business.feign.fallback;

import com.appleyk.business.feign.IntegralService;
import com.appleyk.common.response.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 22:45 2020/9/28
 */
@Service
public class IntegralServiceFallback implements IntegralService {

    /***
     * 降级回调函数，当源接口访问超时或者不可访问时，调用改方法，做"特殊"处理
     * @param uid 用户id
     * @param integral 积分
     * @return
     */
    @Override
    public ResponseResult add(Long uid,Integer integral) {
        // 记录降级日志，后续进行补偿
        System.out.println("调用积分服务失败，开启日志，记录降级处理信息，userId = "+
                uid+",要加的积分 = "+integral);
        return ResponseResult.fail("调用积分服务失败！");
    }
}
