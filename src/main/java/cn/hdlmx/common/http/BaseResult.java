package cn.hdlmx.common.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("基础Response")
@Data
public class BaseResult<T> {
    @ApiModelProperty("消息")
    private String msg = "success";
    @ApiModelProperty("http response code")
    private Integer code = 200;
    @ApiModelProperty("response body")
    private T data;
}
