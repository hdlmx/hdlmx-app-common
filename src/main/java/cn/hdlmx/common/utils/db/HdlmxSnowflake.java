package cn.hdlmx.common.utils.db;

/**
 * hdlmx的雪花id
 * snowflake=占位符+时间戳+workerId(datacenter+worker)+sequence
 * +------+----------------------+----------------+-----------+
 * | sign |     delta seconds    | worker node id | sequence  |
 * +------+----------------------+----------------+-----------+
 * 1bit          28bits              22bits         13bits
 *
 *
 * @author 503330348
 * @createdDate 2023/9/4 14:41
 */
public class HdlmxSnowflake {
    /**
     * 时间戳位数：41
     */
    private long timestampBit = 41L;
    /**
     * worker 位数：10
     */
    private long workerIdBit = 10L;
    /**
     * 序列位数：12
     */
    private long sequence = 12L;
    /**
     * 默认worker id
     */
    private long workWorkerId = 0L;
    /**
     * 已经使用的有效的时间戳
     */
    private long lastTimeStamp;

    /**
     * 获取snowflake id
     *
     * @return
     */


    public synchronized static long nextId() {
        long timeStamp = System.currentTimeMillis();


    }
}
