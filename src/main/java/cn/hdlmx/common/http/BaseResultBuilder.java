package cn.hdlmx.common.http;

import cn.hdlmx.common.baseEnum.ResponseStatusEnum;

public class BaseResultBuilder<T> {
    /**
     * 成功的请求
     *
     * @return 成功的请求
     */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 失败的请求
     */

    public static <T> BaseResult<T> failed(T data) {
        return new BaseResult<>(ResponseStatusEnum.ERROR.getCode(), ResponseStatusEnum.ERROR.getMsg(), data);
    }

    /**
     * 接口不存在
     */

    public BaseResult<T> notFound(T data) {
        return new BaseResult<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMsg(), data);
    }

    /**
     * 接口未认证
     */
    public static <T> BaseResult<T> unauthorized(T data) {
        return new BaseResult<>(ResponseStatusEnum.UNAUTHORIZED.getCode(), ResponseStatusEnum.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 通用的生成返回结果
     *
     * @param code http状态码
     * @param msg  简单消息
     * @param data response body
     * @return 返回结果
     */

    public static <T> BaseResult<T> buildResult(Integer code, String msg, T data) {
        return new BaseResult<>(code, msg, data);
    }

}
