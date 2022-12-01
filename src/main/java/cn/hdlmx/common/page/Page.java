package cn.hdlmx.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Objects;

@ApiModel("分页")
@Data
public class Page {
    @ApiModelProperty("当前页")
    @Min(1)
    private Integer page = 1;
    @ApiModelProperty("分页大小")
    @Min(1)
    private Integer pageSize = 10;
    @ApiModelProperty("总数")
    @Min(0)
    private Integer total = 0;
    @ApiModelProperty("总页数")
    @Min(0)
    private Integer totalPage = 0;

    /**
     * 设置总数并计算页数
     *
     * @param total 总数
     */
    public void setTotal(Integer total) {
        if (Objects.nonNull(total)) {
            this.total = total;
            if (Objects.nonNull(pageSize) && this.pageSize > 0) {
                this.totalPage = (this.total + this.pageSize - 1) / pageSize;
            }
        }

    }


}
