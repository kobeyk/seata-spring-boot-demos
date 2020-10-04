package com.appleyk.common.enums;

/**
 * <p>结果代码枚举 -- 定义返回的结果状态码code和值name </p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 上午 10:46 2019-4-27
 */
public enum ResultCode {


    /***成功*/
    OK(200,"成功"),

    /***失败*/
    FAIL(400,"失败"),

    /***失败*/
    EXCEPTION(500,"系统异常");

    /** 果状态码*/
    private final Integer code;

    /***结果状态码表示的内容*/
    private final String message;

    ResultCode(final Integer code , final String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
