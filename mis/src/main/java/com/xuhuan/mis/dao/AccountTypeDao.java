package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账务类型dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:39
 */
@Repository
public interface AccountTypeDao {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    AccountType selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(AccountType entity);

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
    void update(AccountType entity);

    /**
     * 列表查询
     * @param searchMap
     * @return
     */
    List<Map> selectByParam(Map searchMap);

    /**
     * 根据账务类型查询
     * @param type
     * @return
     */
    List<Map> selectByType(String type);
}
