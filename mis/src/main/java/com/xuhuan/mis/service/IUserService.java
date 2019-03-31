package com.xuhuan.mis.service;

import com.xuhuan.mis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户service
 *
 * @author huan.xu
 * @Time 2019-02-27 17:23
 */
public interface IUserService {
    /**
     * 保存用户
     *
     * @param paramMap
     */
    void saveFormData(Map paramMap);

    /**
     * 列表查询
     *
     * @param searchMap
     * @return
     */
    List<Map> getTableQuery(Map searchMap);


    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 保存用户信息
     *
     * @param entity
     */
    void saveUser(User entity);

    /**
     * 删除用户
     *
     * @param idsStr 逗号分个的id字符串
     */
    void deleteUser(String idsStr);

    /**
     * 根据登录名查找用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
}
