package cn.hdlmx.common.http;

import cn.hdlmx.common.baseEnum.ResponseStatusEnum;

public class BaseResultUtils<T> {
    /**
     * 成功的请求
     */
    public BaseResult<T> success = new BaseResult<>(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg());
    /**
     * 失败的请求
     */
    public BaseResult<T> failed = new BaseResult<>(ResponseStatusEnum.ERROR.getCode(), ResponseStatusEnum.ERROR.getMsg());
    /**
     * 接口不存在
     */
    public BaseResult<T> notFound = new BaseResult<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMsg());
    /**
     * 接口未认证
     */
    public BaseResult<T> unauthorized = new BaseResult<>(ResponseStatusEnum.UNAUTHORIZE.getCode(), ResponseStatusEnum.UNAUTHORIZE.getMsg());

    public BaseResult<T> buildResult(Integer code, String msg) {
        return new BaseResult<>(code, msg);
    }

}
