package cn.hdlmx.common.exception;

public class BusinessException extends RuntimeException {

    private Integer code = 500;
    private final String msg;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, Integer code, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
