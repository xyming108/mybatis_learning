package com.xym.Dao;

import com.xym.domain.Account;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/23 9:36
 * @author: 1931559710@qq.com
 * ClassName: Account
 * Description:
 */
public interface AccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     *
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
