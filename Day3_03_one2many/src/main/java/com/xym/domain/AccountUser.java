package com.xym.domain;

/**
 * @user: Hasee
 * @date: 2021/2/21 22:18
 * @author: 1931559710@qq.com
 * ClassName: AccountUser
 * Description:
 */
public class AccountUser extends Account {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "      AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
