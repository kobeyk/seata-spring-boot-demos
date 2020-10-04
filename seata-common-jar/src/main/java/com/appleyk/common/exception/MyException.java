package com.appleyk.common.exception;

/**
 * <p>自定义异常类</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 上午 11:31 2019-4-27
 */
public class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
