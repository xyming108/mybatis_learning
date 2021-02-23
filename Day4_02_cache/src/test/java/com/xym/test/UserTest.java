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
import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/17 14:43
 * @author: 1931559710@qq.com
 * ClassName: AccountTest
 * Description:mybatis的入门
 */
public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory factory;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After  //用于在测试方法执行之后执行
    public void destory() throws Exception {
        //提交事务
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache() {
        User user1 = userDao.findById(41);
        System.out.println(user1);

        /*sqlSession.close();
        //再次获取SqlSession对象
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);*/

        //此方法也可以清空缓存
        sqlSession.clearCache();

        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache() {
        //根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("江西省瑞金市");
        userDao.updateUser(user1);

        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
