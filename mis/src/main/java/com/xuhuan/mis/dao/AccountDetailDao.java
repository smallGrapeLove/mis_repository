package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账务明细dao
 *
 * @author huan.xu
 * @Time 2019-02-28 11:40
 */
@Repository
public interface AccountDetailDao {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    AccountDetail selectById(int id);

    /**
     * 新增
     *
     * @param entity
     */
    void save(AccountDetail entity);

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
    void update(AccountDetail entity);

    /**
     * 根据账务申请id删除
     * @param applyId
     */
    void deleteByApplyId(int applyId);

    /**
     * 根据账务申请id查询
     * @param applyId
     * @return
     */
    List<Map> selectByApplyId(int applyId);
}
