package com.zrx.common.exceptions;

/**
 * @author 张日雄
 * @date 2017-09-08 0:25
 * @since 1.0
 */
public class BizException extends BizFatherException {
    private static final long serialVersionUID = -5875371379845226068L;

    /**
     * 获取序列出错
     */
    public static final BizException DB_GET_SEQ_NEXT_VALUE_ERROR = new BizException(90040001, "获取序列出错");

    /**
     * 接口json参数为空
     */
    public static final BizException JSON_PARAM_IS_NULL = new BizException(90040002, "接口json参数为空");

    /**
     * 接口json参数格式不正确
     */
    public static final BizException JSON_PARAM_FORMAT_ERROR = new BizException(90040003, "接口json参数格式错误");

    /**
     * 会话超时　获取session时，如果是空，throws 下面这个异常 拦截器会拦截爆会话超时页面
     */
    public static final BizException SESSION_IS_OUT_TIME = new BizException(90040006, "会话超时");

    /***
     * 传入参数为null
     */
    public static final int INPUT_DATA_IS_NULL = 90040007;
    /**
     * 异常信息
     */
//	protected String msg;

    /**
     * 具体异常码
     */
//	protected int code;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException(int code, String msgFormat, Throwable cause,  Object... args) {
        super(String.format(msgFormat, args), cause);
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public BizException(Throwable cause) {
        super(cause);
        this.msg = cause.getMessage();
    }

    public BizException(String message) {
        super(message);
        this.msg = message;
    }
}
