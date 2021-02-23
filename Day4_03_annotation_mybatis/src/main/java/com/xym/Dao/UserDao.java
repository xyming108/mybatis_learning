package com.xym.Dao;

import com.xym.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/23 14:05
 * @author: 1931559710@qq.com
 * ClassName: UserDao
 * Description:在mybati中针对CRUD一共有四个注解：@Select @Insert @Update @Delete
 */
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username, address, sex, birthday)values(#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username=#{username}, address=#{address}, sex=#{sex}, birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    /**
     * 根据id查询一个用户
     *
     * @param userId
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     *
     * @param username
     * @return
     */
    /*@Select("select * from user where username like #{username}")*/
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);

    /**
     * 查询总用户数量
     *
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();
}
