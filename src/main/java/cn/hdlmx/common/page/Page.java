package cn.hdlmx.common.page;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Objects;

@ApiModel("分页")
@Data
public class Page {
    @Min(1)
    private Integer page = 1;
    @Min(1)
    private Integer pageSize = 10;
    @Min(0)
    private Integer total = 0;
    @Min(0)
    private Integer totalPage = 0;

    public void setTotal(Integer total) {
        if (Objects.nonNull(total)) {
            this.total = total;
            if (Objects.nonNull(pageSize) && this.pageSize > 0) {
                this.totalPage = (this.total + this.pageSize - 1) / pageSize;
            }
        }

    }


}
