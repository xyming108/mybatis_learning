package com.xym.Dao.impl;

import com.xym.Dao.UserDao;
import com.xym.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/17 18:20
 * @author: 1931559710@qq.com
 * ClassName: UserDaoImpl
 * Description:
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1、使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2、使用session执行查询所有方法
        List<User> users = session.selectList("com.xym.Dao.UserDao.findAll");
        session.close();
        //3、返回查询结果
        return users;
    }
}
