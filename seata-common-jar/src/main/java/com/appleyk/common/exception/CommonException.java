package com.appleyk.common.exception;

import com.appleyk.common.enums.ResultCode;
import com.appleyk.common.response.ResponseResult;
import org.springframework.http.HttpStatus;

/**
 * <p>自定义通用异常类</p>
 *
 * @author appleyk
 * @version V.1.0.0
 * @blob https://blog.csdn.net/appleyk
 * @date created on 上午 10:59 2019-4-27
 */
public class CommonException extends Exception{

    /**结果状态码*/
    private ResultCode resultCode;

    /**结果消息*/
    private String message;

    public CommonException(ResultCode resultCode,String message){
        super(message);
        this.resultCode = resultCode;
        this.message = message;
    }

    public class ResultError{

        /**错误码*/
        private Integer code;

        /**错误名称*/
        private String message;

        public ResultError(Integer code , String message){
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public ResponseResult buildResult(){
        Integer code = this.resultCode.getCode();
        String name = this.resultCode.getMessage();
        return new ResponseResult(HttpStatus.BAD_REQUEST.value(),this.message , new ResultError(code, name));
    }

}
