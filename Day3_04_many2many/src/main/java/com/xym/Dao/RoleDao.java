package com.xym.Dao;

import com.xym.domain.Role;

import java.util.List;

/**
 * @user: Hasee
 * @date: 2021/2/22 20:50
 * @author: 1931559710@qq.com
 * ClassName: RoleDao
 * Description:
 */
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
