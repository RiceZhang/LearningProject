package com.zrx.common.exceptions;

/**
 *
 * @author 张日雄
 * @date 2017-09-20 0:32
 * @since 1.0
 */
public enum StatusCode {

    PARSEERROR(-32700,"Parse error","语法解析错误"),
    INVALIDREQUEST(-32600,"Invalid Request","无效请求"),
    METHODNOTFOUND(-32601,"Method not found","找不到方法"),
    INVALIDPARAMS(-32602,"Invalid params","无效的参数"),
    INTERNALERROR(-32603,"Internal error","内部错误")
    // -32000 to -32099 Server error服务端错误 预留用于自定义的服务器错误。
    ;

    private int code;

    private String msg_en;

    private String msg_cn;

    StatusCode(int code, String msg_en, String msg_cn) {
       this.code = code;
       this.msg_en = msg_en;
       this.msg_cn = msg_cn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg_en() {
        return msg_en;
    }

    public void setMsg_en(String msg_en) {
        this.msg_en = msg_en;
    }

    public String getMsg_cn() {
        return msg_cn;
    }

    public void setMsg_cn(String msg_cn) {
        this.msg_cn = msg_cn;
    }
}
