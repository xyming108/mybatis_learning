package com.xym.test;

import com.xym.Dao.AccountDao;
import com.xym.domain.Account;
import com.xym.domain.AccountUser;
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
public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1、读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3、获取SqlSession对象
        sqlSession = factory.openSession();
        //4、获取dao的代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
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
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 测试查询所有账户，同时包含用户名和地址
     */
    @Test
    public void testFindAllAccountUser() {
        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser au : aus) {
            System.out.println(au);
        }
    }
}
