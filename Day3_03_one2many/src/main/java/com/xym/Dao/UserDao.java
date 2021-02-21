package com.xym.Dao;

import com.xym.domain.QueryVo;
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
     * 查询所有用户
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
     * 根据名称模糊查询用户信息
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);


    /**
     * 根据queryVo中的条件查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件查询
     *
     * @param user 查询的条件，有可能有用户名，有可能有性别，有可能有地址，有可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合，查询用户信息
     *
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

}
