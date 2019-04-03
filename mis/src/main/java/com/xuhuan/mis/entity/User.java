package com.xuhuan.mis.entity;

/**
 * 用户
 *
 * @author huan.xu
 * @Time 2019-02-27 17:04
 */
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 登录名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", showName='" + showName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
