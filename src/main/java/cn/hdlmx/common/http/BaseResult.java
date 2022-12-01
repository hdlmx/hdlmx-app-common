package cn.hdlmx.common.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hdlmx
 */
@ApiModel("基础Response")
public class BaseResult<T> {
    @ApiModelProperty("消息")
    private String msg = "success";
    @ApiModelProperty("http response code")
    private Integer code = 200;
    @ApiModelProperty("response body")
    private T data;

    public BaseResult(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public BaseResult(Integer code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public BaseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
