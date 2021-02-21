package com.xym.mybatis.SqlSession;

/**
 * @user: Hasee
 * @date: 2021/2/19 10:12
 * @author: 1931559710@qq.com
 * ClassName: SqlSession
 * Description:自定义Mybatis中和数据库交互的核心类，
 * 它里面可以创建dao接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
