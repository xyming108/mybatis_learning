package com.xym.Dao;

import com.xym.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/23 14:05
 * @author: 1931559710@qq.com
 * ClassName: UserDao
 * Description:在mybati中针对CRUD一共有四个注解：@Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.xym.Dao.AccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询一个用户
     *
     * @param userId
     */
    @Select("select * from user where id=#{id}")
    /*正规写法*/
    /*@ResultMap(value = {"userMap"})*/
    /*如果只有一个元素如：userMap，则value和大括号可以省略*/
    @ResultMap("userMap")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);
}
