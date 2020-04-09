package com.lin.landao.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class KeyUtil {
    private KeyUtil(){

    }
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized Integer genUniqueKey() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        UUID a=UUID.randomUUID();
        Integer number = random.nextInt(100000) ;
        return number;
    }
}
