package com.sunyt.mindcoll.util;

public class GlobalResponse<T> {

    public static final String SUCCESS = "1";

    public static final String FAIL = "0";
    /**
     * 返回代码：1-成功 0-失败
     */
    private String code;
    /**
     * 错误返回信息
     */
    private String message;
    /**
     * 成功返回数据
     */
    private T data;

    public GlobalResponse(){

    }

    public GlobalResponse(String code){
        this.code = code;
    }

    private GlobalResponse(T data, String code){
        this.code = code;
        this.data = data;
    }

    private GlobalResponse(String message, String code){
        this.code = code;
        this.message = message;
    }

    public static <T> GlobalResponse<T> success(T data){
        return new GlobalResponse<>(data, GlobalResponse.SUCCESS);
    }
    public static <T> GlobalResponse<T> success(){
        return new GlobalResponse<>(GlobalResponse.SUCCESS);
    }

    public static <T> GlobalResponse<T> fail(String message){
        return new GlobalResponse<>(message, GlobalResponse.FAIL);
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getFAIL() {
        return FAIL;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
