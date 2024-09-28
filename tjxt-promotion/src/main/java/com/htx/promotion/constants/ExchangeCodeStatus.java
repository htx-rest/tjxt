package com.htx.promotion.constants;

import com.htx.common.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExchangeCodeStatus implements BaseEnum {
    UNUSED(1, "待兑换"),
    USED(2, "已兑换"),
    EXPIRED(3, "兑换活动已结束"),
    ;
    private final int value;
    private final String desc;

    public static ExchangeCodeStatus of(Integer value) {
        if (value == null) {
            return null;
        }
        for (ExchangeCodeStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

    public static String desc(Integer value) {
        ExchangeCodeStatus status = of(value);
        return status == null ? "" : status.desc;
    }
}
