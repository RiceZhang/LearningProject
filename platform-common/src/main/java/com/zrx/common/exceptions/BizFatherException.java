package com.zrx.common.exceptions;

/**
 * @author 张日雄
 * @date 2017-09-08 0:25
 * @since 1.0
 */
public class BizFatherException extends RuntimeException  {
    private static final long serialVersionUID = -5875371379845226068L;


    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public BizFatherException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizFatherException() {
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
    public BizFatherException newInstance(String msgFormat, Object... args) {
        return new BizFatherException(this.code, msgFormat, args);
    }

    public BizFatherException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizFatherException(Throwable cause) {
        super(cause);
    }

    public BizFatherException(String message) {
        super(message);
    }
}
