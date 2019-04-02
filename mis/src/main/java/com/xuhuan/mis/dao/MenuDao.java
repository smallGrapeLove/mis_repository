package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.Menu;
import com.xuhuan.mis.entity.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 菜单dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:41
 */
@Repository
public interface MenuDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Menu selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(Menu entity);

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
    void update(Menu entity);

    /**
     * 根据参数查询
     *
     * @param searchMap
     * @return
     */
    List<Map> selectByParam(Map searchMap);

    /**
     * 根据上级菜单id查询子菜单
     * @param parentId
     * @return
     */
    List<Map> selectByParentId(Integer parentId);

}
