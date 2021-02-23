package com.xym.Dao;

import com.xym.domain.User;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/16 10:50
 * @author: 1931559710@qq.com
 * ClassName: UserDao
 * Description:用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);
}
