package com.xym.mybatis.utils;

import com.xym.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @user: Hasee
 * @date: 2021/2/19 20:12
 * @author: 1931559710@qq.com
 * ClassName: DataSourceUtil
 * Description:用于创建数据源的工具类
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
