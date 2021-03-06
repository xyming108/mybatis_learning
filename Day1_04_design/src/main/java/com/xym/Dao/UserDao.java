package com.xym.Dao;

import com.xym.domain.User;
import com.xym.mybatis.annotations.Select;

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
     * 查询所有操作
     */
    @Select("select * from user")
    List<User> findAll();
}
