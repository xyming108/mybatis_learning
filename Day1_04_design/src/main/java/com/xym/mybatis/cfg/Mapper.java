package com.xym.mybatis.cfg;

/**
 * @user: Hasee
 * @date: 2021/2/19 10:56
 * @author: 1931559710@qq.com
 * ClassName: Mapper
 * Description:用于封装执行的SQL语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;     //SQL
    private String resultType;      //实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "queryString='" + queryString + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}
