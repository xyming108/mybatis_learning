package com.xym.mybatis.io;

import java.io.InputStream;

/**
 * @user: Hasee
 * @date: 2021/2/18 19:45
 * @author: 1931559710@qq.com
 * ClassName: Resources
 * Description:
 */
public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
