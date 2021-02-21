package com.xym.Dao;

import com.xym.domain.Account;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/21 21:53
 * @author: 1931559710@qq.com
 * ClassName: AccountDao
 * Description:
 */
public interface AccountDao {
    /**
     * 查询所有帐户
     * @return
     */
    List<Account> findAll();
}
