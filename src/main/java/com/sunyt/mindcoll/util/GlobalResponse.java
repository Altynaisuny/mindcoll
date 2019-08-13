package com.sunyt.mindcoll.util;

public class GlobalResponse<T> {

    private static final String SUCCESS = "1";

    private static final String FAIL = "0";
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

    private GlobalResponse(String code){
        this.code = code;
    }

    private GlobalResponse(String code, T data){
        this.code = code;
        this.data = data;
    }

    private GlobalResponse(String code, String message){
        this.code = code;
        this.message = message;
    }

    private GlobalResponse(String code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> GlobalResponse<T> success(T data){
        return new GlobalResponse<>(GlobalResponse.SUCCESS, data);
    }
    public static <T> GlobalResponse<T> success(){
        return new GlobalResponse<>(GlobalResponse.SUCCESS);
    }

    public static <T> GlobalResponse<T> fail(String message){
        return new GlobalResponse<>(GlobalResponse.FAIL, message);
    }
    public static <T> GlobalResponse<T> fail(String message, T data){
        return new GlobalResponse<>(GlobalResponse.FAIL, message, data);
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
