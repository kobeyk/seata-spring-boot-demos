package com.appleyk.business.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>sentinel服务熔断、降级、限流测试Controller</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 21:14 2020/10/8
 */
@CrossOrigin
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/hello")
    public String hello(){
        // 使用限流规则
        try(Entry entry = SphU.entry("hello")){ // 限流入口，锁定某一资源
            // 被保护的资源，在限流规则内，正常返回
            return "Hello Sentinel !";
        }catch (BlockException e){
            // 超出限流规则，则抛出异常，异常中可以自定义业务逻辑，并返回相应结果
            return "系统繁忙，请稍候再试！";
        }
    }

    @PostConstruct// 在当前类的构造函数执行之后调用
    public void initFlowRules(){
        /**1.创建存放限流规则的集合*/
        List<FlowRule> flowRules = new ArrayList<>();
        /**2.创建限流规则*/
        FlowRule flowRule = new FlowRule();
        /**3.定义资源，表示sentinel会对哪个资源产生限流*/
        flowRule.setResource("hello");
        /**4.定义限流规则类型，RuleConstant.FLOW_GRADE_QPS,QPS，每秒访问量*/
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        /**5.定义限流规则类型下，访问的数量（次数）,即每秒能通过的请求个数*/
        flowRule.setCount(2);
        /**6.将限流规则存放到集合中*/
        flowRules.add(flowRule);
        /**7.加载限流规则*/
        FlowRuleManager.loadRules(flowRules);
    }

}
