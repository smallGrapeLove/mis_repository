package com.xuhuan.mis.dao;

import org.springframework.stereotype.Repository;
import com.xuhuan.mis.entity.Enum;

import java.util.List;
import java.util.Map;

/**
 * 枚举dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:41
 */
@Repository
public interface EnumDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Enum selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(Enum entity);

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
    void update(Enum entity);

    /**
     * 根据参数查询
     * @param searchMap
     * @return
     */
    List<Map> selectByParam(Map searchMap);

    /**
     * 根据模块和类型查询枚举
     * @param catalog
     * @param type
     * @return
     */
    List<Map> selectByCatalogAndType(String catalog,String type);
}
