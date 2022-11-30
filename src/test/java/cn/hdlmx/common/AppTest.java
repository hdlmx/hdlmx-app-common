package cn.hdlmx.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cn.hdlmx.common.http.BaseResultBuilder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertEquals(BaseResultBuilder.success("ss"),BaseResultBuilder.success("ss"));

        assertTrue(true);
    }

}
