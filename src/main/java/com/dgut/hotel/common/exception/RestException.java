package com.dgut.hotel.common.exception;

import com.dgut.hotel.common.api.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常的基础类
 */
public class RestException extends RuntimeException{

    public static final Logger LOGGER = LoggerFactory.getLogger(RestException.class);

    /**
     * 异常码
     */
    private Long code;

    /**
     * 异常提示
     */
    private String message;

    /**
     * 异常错误
     */
    private String error;

    public RestException(Throwable e){
        super(e.getMessage());
        setError(e);
    }

    public RestException(ResultCode code){
        super(code.getMessage());
        setCode(code.getCode());
        setMessage(code.getMessage());
    }

    public RestException(ResultCode code, String message) {
        super(message);
        setCode(code.getCode());
        setMessage(message);
    }

    public RestException(String message){
        super(message);
        setMessage(message);
    }

    public RestException(String message, Throwable e){
        super(message);
        this.message = message;
        setError(e);
    }

    public RestException(Long code, String message) {
        super(message);
        setCode(code);
        setMessage(message);
    }

    public RestException(Long code, String message, String error){
        super(message);
        setCode(code);
        setMessage(message);
        this.error = error;
    }

    public RestException(Long code, String message, Throwable e){
        super(message);
        setCode(code);
        setMessage(message);
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void setError(Throwable e){
        LOGGER.error("系统异常", e);
        e.printStackTrace();
        this.code = ResultCode.FAILED.getCode();
        if(this.message == null) {
            this.message = ResultCode.FAILED.getMessage();
        }
        this.error = e.toString();
    }
}
