package com.xuhuan.mis.service;

import com.xuhuan.mis.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * 角色service
 * @author huan.xu
 * @Time 2019-02-27 17:21
 */
public interface IRoleService {

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    Role getRoleById(int id);

    /**
     * 保存表单数据
     * @param paramMap
     */
    void saveFormData(Map paramMap);

    /**
     * 保存角色信息
     * @param role
     */
    void saveRole(Role role);
    /**
     * 列表查询
     * @param searchMap
     * @return
     */
    List<Map> getTableQuery(Map searchMap);

    /**
     * 删除角色
     * @param idsStr 逗号分个的id字符串
     */
    void deleteRole(String idsStr);
}
