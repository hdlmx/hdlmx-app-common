package cn.hdlmx.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Objects;

@ApiModel("分页")
@Data
public class Page {
    @Min(1)
    @ApiModelProperty("当前页")
    private Integer page = 1;
    @Min(1)
    @ApiModelProperty("分页大小")
    private Integer pageSize = 10;
    @Min(0)
    @ApiModelProperty("总数")
    private Integer total = 0;
    @Min(0)
    @ApiModelProperty("总页数")
    private Integer totalPage = 0;

    /**
     * 设置总数，自动计算分页
     *
     * @param total 结果总数
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
