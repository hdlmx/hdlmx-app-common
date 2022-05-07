package cn.hdlmx.common.baseEnum;

import cn.hdlmx.common.exception.BusinessException;

public interface BaseEnumI {
    Integer getCode();

    String getValue();

    default BusinessException buildException() {
        return new BusinessException(this.getValue(), this.getCode(), null);
    }

    default BusinessException businessException(Throwable e) {
        return new BusinessException(this.getValue(), this.getCode(), e);
    }

}
