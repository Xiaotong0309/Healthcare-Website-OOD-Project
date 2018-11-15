package com.test.health.vo;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7706430141206682077L;

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    public Result() {
    }

    public Result(Integer code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = null;
    }

    public Result(Integer code, String msg, T data, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> Result<T> success(){
        return new Result<T>(0, "Success", true);
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(0, "Success", data,true);
    }

    public static <T> Result<T> success(Integer code, String msg, T data){
        return new Result<T>(code, msg, data, true);
    }

    public static <T> Result<T> fail(){
        return new Result<T>(-1, "Failed", false);
    }

    public static <T> Result<T> fail(String msg){
        return new Result<T>(-1, msg, false);
    }

    public static <T> Result<T> fail(Integer code, String msg){
        return new Result<T>(code, msg, null, false);
    }
    public static <T> Result<T> fail(Integer code, String msg, T data){
        return new Result<T>(code, msg, data, false);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
