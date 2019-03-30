package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Role selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(Role entity);

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
    void update(Role entity);

    /**
     * 根据参数查询
     *
     * @param searchMap
     * @return
     */
    List<Map> selectByParam(Map searchMap);


}
