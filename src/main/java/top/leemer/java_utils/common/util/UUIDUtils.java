package top.leemer.java_utils.common.util;

import java.util.UUID;

/**
 * @author LEEMER
 * Create Date: 2019-10-11
 */
public class UUIDUtils {

    /**
     * 获取UUID
     * @return uuid
     */
    public String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
