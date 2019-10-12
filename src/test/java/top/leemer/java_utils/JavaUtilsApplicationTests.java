package top.leemer.java_utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.leemer.java_utils.common.util.FileCoderUtils;
import top.leemer.java_utils.common.util.RSACoderUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaUtilsApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        String publicKey = RSACoderUtils.loadPublicKey();
        String privateKey = RSACoderUtils.loadPrivateKey();

        System.out.println("公钥：\r\n" + publicKey);
        System.out.println("私钥：\r\n" + privateKey);

        String data = "你是风儿我是沙";

        byte[] encryptData = RSACoderUtils.encryptByPrivateKey(data);

        byte[] decryptData = RSACoderUtils.decryptByPublicKey(encryptData);

        System.err.println("加密前：\r\n" + data);
        System.err.println("加密后：\r\n" + new String(encryptData));
        System.err.println("解密后：\r\n" + new String(decryptData));
    }

    @Test
    public void fileCoder() throws IOException {

        //读取原文件
        byte[] orgData = Files.readAllBytes(Paths.get("e:/test.txt"));

        //加密原文件
        FileCoderUtils.fileEncryptByPrivateKey(orgData, "test");

        //读取加密文件
        byte[] encryptData = Files.readAllBytes(Paths.get("e:/test.leemer"));

        //创建解密文件
        FileCoderUtils.fileDecryptByPublicKey(encryptData, "new test");
    }

}
