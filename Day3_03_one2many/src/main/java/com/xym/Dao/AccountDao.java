package com.xym.Dao;

import com.xym.domain.Account;
import com.xym.domain.AccountUser;

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
     * 查询所有帐户，同时还要获取到当前账户的所属用户信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有帐户，并且带有用户名和地址信息
     *
     * @return
     */
    List<AccountUser> findAllAccount();
}
