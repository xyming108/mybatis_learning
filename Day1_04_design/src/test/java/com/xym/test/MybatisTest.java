package com.xym.test;

import com.xym.Dao.UserDao;
import com.xym.domain.User;
import com.xym.mybatis.SqlSession.SqlSession;
import com.xym.mybatis.SqlSession.SqlSessionFactory;
import com.xym.mybatis.SqlSession.SqlSessionFactoryBuilder;
import com.xym.mybatis.io.Resources;

import java.io.InputStream;
import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/17 14:43
 * @author: 1931559710@qq.com
 * ClassName: MybatisTest
 * Description:mybatis的入门
 */
public class MybatisTest {
    /**
     * 入门案例
     */
    public static void main(String[] args) throws Exception {
        //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3、使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4、使用SqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6、释放资源
        session.close();
        in.close();
    }
}
