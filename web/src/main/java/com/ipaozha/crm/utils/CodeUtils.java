package com.ipaozha.crm.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CodeUtils {

    /**
     * Md5加密
     * @param str
     * @return
     */
    public static String Md5encode(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * Base64加密
     * @param str
     * @return
     */
    public static String Base64encode(String str) {
        byte[] b = Base64.encodeBase64(str.getBytes(), true);
        return new String(b);
    }
    /**
     * Base64解密
     * @param str
     * @return
     */
    public static String Base64decode(String str) {
        byte[] b = Base64.decodeBase64(str.getBytes());
        return new String(b);
    }

    /**
     * 生成SHA1
     */
    public static String SHA1encode(String str) {
        return DigestUtils.sha1Hex(str);
    }
}
