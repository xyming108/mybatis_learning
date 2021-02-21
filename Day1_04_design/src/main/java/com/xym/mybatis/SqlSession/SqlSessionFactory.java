package com.xym.mybatis.SqlSession;

/**
 * @user: Hasee
 * @date: 2021/2/19 10:09
 * @author: 1931559710@qq.com
 * ClassName: SqlSessionFactory
 * Description:
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
