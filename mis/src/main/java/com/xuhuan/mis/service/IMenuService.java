package com.xuhuan.mis.service;

import com.xuhuan.mis.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单service
 *
 * @author huan.xu
 * @Time 2019-02-27 17:23
 */
public interface IMenuService {

    /**
     * 列表查询
     *
     * @param paramMap
     * @return
     */
    List<Map> getTableQuery(Map<String, String> paramMap);

    /**
     * 根据id查询菜单信息
     *
     * @param id
     * @return
     */
    Menu getMenuById(int id);

    /**
     * 根据上级菜单查询
     *
     * @param parentId
     * @return
     */
    List<Map> getMenuByParentId(int parentId);

    /**
     * 查询有权限的上级菜单
     *
     * @param roleId
     * @param parentId
     * @return
     */
    List<Map> getAuthMenuByParentId(int roleId, int parentId);

    /**
     * 保存表单数据
     *
     * @param paramMap
     */
    void saveFormData(Map paramMap);

    /**
     * 保存菜单信息
     *
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 删除菜单
     *
     * @param idsStr 逗号分个的id字符串
     */
    void deleteMenu(String idsStr);

    /**
     * 组装下拉框选项
     *
     * @param showLastFlag 是否显示第三级菜单
     * @return
     */
    Map makeSelectOption(boolean showLastFlag);

    /**
     * 组装左侧导航栏数据
     *
     * @param roleId
     * @return
     */
    List<Map> makeLeftPageData(int roleId);

    /**
     * 组装角色权限数据
     * 角色菜单配置使用
     *
     * @param roleId
     * @return
     */
    List<Map> makeRoleMenuData(int roleId);

    /**
     * 检查角色是否有此菜单权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    boolean checkRoleMenu(int roleId, int menuId);

    void deleteRoleMenuByRoleId(int roleId);

    /**
     * 保存角色菜单权限功能表单数据
     *
     * @param paramMap
     */
    void saveRoleMenuFormData(Map<String, Object> paramMap);
}
