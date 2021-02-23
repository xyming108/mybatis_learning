package com.xym.test;

import com.xym.Dao.UserDao;
import com.xym.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/23 17:52
 * @author: 1931559710@qq.com
 * ClassName: AnnotationCRUDTest
 * Description:
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(65);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
