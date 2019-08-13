package com.sunyt.mindcoll.enumeration;

/**
 * 用枚举类统一错误码与错误信息维护
 */
public enum ResultEnum {

    // client errors
    SUCCESS(200, "操作成功"),


    PERMISSION(300, "权限异常"),
    EXCEPTION(500, "起它异常"),
    NOT_FOUND_ID(102, "未知ID");

    private int code;
    private String msg;
    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
