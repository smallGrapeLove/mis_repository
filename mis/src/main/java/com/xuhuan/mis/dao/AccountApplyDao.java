package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountApply;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账务申请dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:40
 */
@Repository
public interface AccountApplyDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    AccountApply selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(AccountApply entity);

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
    void update(AccountApply entity);


    /**
     * 账务记录列表专用
     * @param paramMap
     * @return
     */
    List<Map> selectTableQuery(Map paramMap);


}
