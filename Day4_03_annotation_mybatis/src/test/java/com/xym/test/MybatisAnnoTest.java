package com.xym.test;

import com.xym.Dao.UserDao;
import com.xym.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/23 17:34
 * @author: 1931559710@qq.com
 * ClassName: MybatisAnnoTest
 * Description:
 */
public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //根据字节输入流构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //根据SqlSessionFactory产生一个SqlSession
        SqlSession session = factory.openSession();
        //使用SqlSession获取Dao的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //执行Dao方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
