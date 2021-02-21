package com.xym.mybatis.SqlSession.defaults;

import com.xym.mybatis.SqlSession.SqlSession;
import com.xym.mybatis.SqlSession.proxy.MapperProxy;
import com.xym.mybatis.cfg.Configuration;
import com.xym.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @user: Hasee
 * @date: 2021/2/19 11:52
 * @author: 1931559710@qq.com
 * ClassName: DefaultSqlSession
 * Description:SqlSession接口的实现
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(),
                connection));
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
