package com.xym.test;

import com.xym.Dao.UserDao;
import com.xym.Dao.impl.UserDaoImpl;
import com.xym.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        //3、使用工厂创建dao对象
        UserDao userDao = new UserDaoImpl(factory);
        //4、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //5、释放资源
        in.close();
    }
}
