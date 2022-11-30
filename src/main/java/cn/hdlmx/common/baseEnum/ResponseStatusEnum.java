package cn.hdlmx.common.baseEnum;

/**
 * 返回结果状态码
 */
public enum ResponseStatusEnum {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 服务器内部错误
     */
    ERROR(500, "server error"),
    /**
     * 请求路径不存在
     */
    NOT_FOUND(404, "not found"),
    /**
     * 未认证
     */
    UNAUTHORIZED(403, "unauthorized");
    /**
     * http状态码
     */
    private final Integer code;
    /**
     * 状态消息
     */
    private final String msg;

    ResponseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

}
