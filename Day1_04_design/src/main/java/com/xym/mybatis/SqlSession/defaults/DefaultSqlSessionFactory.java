package com.xym.mybatis.SqlSession.defaults;

import com.xym.mybatis.SqlSession.SqlSession;
import com.xym.mybatis.SqlSession.SqlSessionFactory;
import com.xym.mybatis.cfg.Configuration;

import javax.crypto.interfaces.PBEKey;

/**
 * @user: Hasee
 * @date: 2021/2/19 11:46
 * @author: 1931559710@qq.com
 * ClassName: DefaultSqlSessionFactory
 * Description:SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
