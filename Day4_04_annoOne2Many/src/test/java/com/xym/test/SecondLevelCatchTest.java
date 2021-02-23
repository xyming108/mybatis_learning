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

import java.io.InputStream;

/**
 * @user: Hasee
 * @date: 2021/2/23 22:00
 * @author: 1931559710@qq.com
 * ClassName: SecondLevelCatchTest
 * Description:
 */
public class SecondLevelCatchTest {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
        in.close();
    }

    @Test
    public void testFindOne() {
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.findById(48);
        System.out.println(user);

        //释放一级缓存
        session.close();

        //再次打开session
        SqlSession session1 = factory.openSession();
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user1 = userDao1.findById(48);
        System.out.println(user1);

        session1.close();
    }
}
