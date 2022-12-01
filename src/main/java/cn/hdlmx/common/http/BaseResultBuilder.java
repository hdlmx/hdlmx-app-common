package cn.hdlmx.common.http;

import cn.hdlmx.common.baseEnum.ResponseStatusEnum;

/**
 * http response result构建工具类
 *
 * @author hdlmx
 * @since 2022/12/1
 */
public class BaseResultBuilder<T> {
    /**
     * @param data response body
     *             成功的请求
     */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg());
    }

    /**
     * 失败的请求
     *
     * @param data response body
     * @return response result
     */
    public static <T> BaseResult<T> failed(T data) {
        return new BaseResult<>(ResponseStatusEnum.ERROR.getCode(), ResponseStatusEnum.ERROR.getMsg());
    }


    /**
     * 接口不存在
     *
     * @param data response body
     * @return response result
     */
    public static <T> BaseResult<T> notFound(T data) {
        return new BaseResult<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMsg(), data);
    }

    /**
     * 接口未认证
     *
     * @param data response body
     * @return response result
     */
    public static <T> BaseResult<T> unauthorized(T data) {
        return new BaseResult<>(ResponseStatusEnum.UNAUTHORIZE.getCode(), ResponseStatusEnum.UNAUTHORIZE.getMsg(), data);
    }

    /**
     * 自定义请求类型
     *
     * @param code
     * @param msg
     * @return response result
     */
    public BaseResult<T> buildResult(Integer code, String msg) {
        return new BaseResult<>(code, msg);
    }

    public static <T> BaseResult<T> buildResult(Integer code, String msg, T data) {
        return new BaseResult<>(code, msg, data);
    }

}
