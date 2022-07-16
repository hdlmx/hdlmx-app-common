package cn.hdlmx.common;

import cn.hdlmx.common.utils.time.TimeUtils;
import org.junit.Test;

import java.time.LocalDateTime;

public class TimeUtilsTest {
    @Test
    public void test() {
        LocalDateTime localDateTime=LocalDateTime.of(2022,1,21,0,0,0);
        LocalDateTime endDateTime=LocalDateTime.of(2022,6,5,0,0,0);

        System.out.println(TimeUtils.timeDurationStr(localDateTime));
        System.out.println(TimeUtils.timeDurationStr(localDateTime,endDateTime));
        System.out.println(135/7);
        System.out.println(135%7);

    }
}
