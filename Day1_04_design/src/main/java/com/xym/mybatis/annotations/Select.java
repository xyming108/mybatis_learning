package com.xym.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @user: Hasee
 * @date: 2021/2/19 21:11
 * @author: 1931559710@qq.com
 * ClassName: Select
 * Description:查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置SQL语句的
     * @return
     */
    String value();
}
