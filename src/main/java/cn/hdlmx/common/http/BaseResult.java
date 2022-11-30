package cn.hdlmx.common.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("基础Response")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
