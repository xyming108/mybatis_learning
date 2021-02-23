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
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("江西省瑞金市");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(66);
        user.setUsername("mybatis annotation");
        user.setAddress("江西省瑞金市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(66);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(65);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        /*List<User> users = userDao.findUserByName("%mybatis%");*/
        List<User> users = userDao.findUserByName("mybatis");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
