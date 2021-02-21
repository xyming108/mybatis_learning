package com.xym.mybatis.SqlSession;

import com.xym.mybatis.SqlSession.defaults.DefaultSqlSessionFactory;
import com.xym.mybatis.cfg.Configuration;
import com.xym.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @user: Hasee
 * @date: 2021/2/19 10:05
 * @author: 1931559710@qq.com
 * ClassName: SqlSessionFactoryBuilder
 * Description:用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
