package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 角色菜单关系dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:42
 */
@Repository
public interface RoleMenuDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    RoleMenu selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(RoleMenu entity);

    /**
     * 删除
     *
     * @param id
     */
    void delete(int id);

    /**
     * 更新
     *
     * @param entity
     */
    void update(RoleMenu entity);

    /**
     * 根据参数查询菜单权限
     * @param searchMap
     * @return
     */
    List<RoleMenu> selectByParam(Map searchMap);
}
