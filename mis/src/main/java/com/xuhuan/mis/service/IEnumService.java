package com.xuhuan.mis.service;

import com.xuhuan.mis.entity.Enum;

import java.util.List;
import java.util.Map; /**
 * 枚举service
 * @author huan.xu
 * @Time 2019-02-27 17:22
 */
public interface IEnumService {
    /**
     * 保存枚举信息
     * @param paramMap
     */
    void saveFormData(Map paramMap);

    /**
     * 列表查询
     * @param searchMap
     * @return
     */
    List<Map> getTableQuery(Map searchMap);


    /**
     * 根据id查询枚举
     * @param id
     * @return
     */
    Enum getEnumById(int id);

    /**
     * 保存角色信息
     * @param entity
     */
    void saveEnum(Enum entity);

    /**
     * 删除枚举
     * @param idsStr 逗号分个的id字符串
     */
    void deleteEnum(String idsStr);

    /**
     * 根据模块和类型查询枚举
     * @param catalog
     * @param type
     * @return
     */
    List<Map> getEnumByCatalogAndType(String catalog,String type);
}
