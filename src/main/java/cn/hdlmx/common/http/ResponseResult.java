package cn.hdlmx.common.http;

import cn.hdlmx.common.baseEnum.BizCode;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 503330348
 * @createdDate 2023/9/1 10:34
 */


@Data
public class ResponseResult<T> {
    /**
     * 前端引用的页面
     */
    private List<String> refUrls;
    /**
     * 数据实体
     */
    private T data;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回结果时间
     */
    private LocalDateTime timestamp =LocalDateTime.now();
    /**
     * 业务编码
     */
    private BizCode bizCode;

    public ResponseResult(T data) {
        this.data = data;
    }

    public ResponseResult(List<String> refUrls, T data) {
        this.refUrls = refUrls;
        this.data = data;
    }

    public ResponseResult(String msg, BizCode bizCode, T data) {
        this.data = data;
        this.msg = msg;
        this.bizCode = bizCode;
    }

    public static <T> ResponseResult<T> OK(T t) {
        return new ResponseResult<>("success", BizCode.QUERY_SUCCESS, t);
    }

    public static <T> ResponseResult<T> OK(String msg, BizCode bizCode, T data) {
        return new ResponseResult<T>(msg, bizCode, data);
    }

    public static <T> ResponseResult<T> FAILED(BizCode bizCode) {
        return new ResponseResult<T>("operation failed", bizCode, null);
    }

    public static <T> ResponseResult<T> FAILED(BizCode bizCode, T data) {
        return new ResponseResult<T>("operation failed", bizCode, data);
    }

}
