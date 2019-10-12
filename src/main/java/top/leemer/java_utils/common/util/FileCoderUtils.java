package top.leemer.java_utils.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;
import static top.leemer.java_utils.common.util.RSACoderUtils.*;

/**
 * 文件加密工具类
 *
 * @author LEEMER
 * Create Date: 2019-10-12
 */
public class FileCoderUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileCoderUtils.class);

    /**
     * 文件首部识别码
     */
    private static final byte[] PREFIX_BYTES = {0xC, 0xC, 0xC};

    private static final String ENCRYPT_FILE_SUFFIX = ".leemer";

    /**
     * 私钥加密文件内容
     * @param data
     * @param filename
     */
    public static void fileEncryptByPrivateKey(byte[] data, String filename){
        byte[] encryptData = encryptByPrivateKey(new String(data));
        byte[] newData = new byte[encryptData.length + 3];
        newData[0] = PREFIX_BYTES[0];
        newData[1] = PREFIX_BYTES[1];
        newData[2] = PREFIX_BYTES[2];
        System.arraycopy(encryptData, 0, newData, 3, encryptData.length);

        try {
            Files.write(
                    Paths.get( "e:" + File.separator + filename + ENCRYPT_FILE_SUFFIX), newData, CREATE
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 公钥解密文件内容
     * @param data
     * @param filename
     */
    public static void fileDecryptByPublicKey(byte[] data, String filename){
        if (data[0] != PREFIX_BYTES[0] && data[1] != PREFIX_BYTES[1] && data[2] != PREFIX_BYTES[2]) {
            LOGGER.error("不支持的文件格式");
            return ;
        }
        byte[] trueData = new byte[data.length - 3];
        System.arraycopy(data, 3, trueData, 0, trueData.length);
        byte[] newData = decryptByPublicKey(trueData);

        try {
            Files.write(
                    Paths.get( "e:" + File.separator + filename + ".txt"), newData, CREATE
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
