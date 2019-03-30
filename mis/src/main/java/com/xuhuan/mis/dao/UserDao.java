package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:42
 */
@Repository
public interface UserDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(User entity);

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
    void update(User entity);

    /**
     * 根据参数查询
     * @param searchMap
     * @return
     */
    List<Map> selectByParam(Map searchMap);
}
