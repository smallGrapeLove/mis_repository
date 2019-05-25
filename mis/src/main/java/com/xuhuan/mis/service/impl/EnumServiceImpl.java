package com.xuhuan.mis.service.impl;

import com.xuhuan.mis.dao.EnumDao;
import com.xuhuan.mis.entity.Enum;
import com.xuhuan.mis.service.IEnumService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 枚举service实现类
 *
 * @author huan.xu
 * @Time 2019-02-27 17:24
 */
@Transactional
@Service("IEnumService")
public class EnumServiceImpl implements IEnumService {

    @Autowired
    private EnumDao enumDao;

    /**
     * 保存枚举信息
     *
     * @param paramMap
     */
    @Override
    public void saveFormData(Map paramMap) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String catalog = StringUtil.safeToString(paramMap.get("catalog"), "");
        String type = StringUtil.safeToString(paramMap.get("type"), "");
        String name = StringUtil.safeToString(paramMap.get("name"), "");
        String value = StringUtil.safeToString(paramMap.get("value"), "");
        String sort = StringUtil.safeToString(paramMap.get("sort"), "");
        String remark = StringUtil.safeToString(paramMap.get("remark"), "");

        Enum entity;
        if (id != 0) {
            entity = this.getEnumById(id);
        } else {
            entity = new Enum();
        }
        entity.setCatalog(catalog);
        entity.setType(type);
        entity.setName(name);
        entity.setValue(value);
        entity.setSort(sort);
        entity.setRemark(remark);
        this.saveEnum(entity);

    }

    /**
     * 列表查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Map> getTableQuery(Map searchMap) {
        return enumDao.selectByParam(searchMap);
    }

    /**
     * 根据id查询枚举
     *
     * @param id
     * @return
     */
    @Override
    public Enum getEnumById(int id) {
        return enumDao.selectById(id);
    }

    /**
     * 保存角色信息
     *
     * @param entity
     */
    @Override
    public void saveEnum(Enum entity) {
        if (entity != null) {
            int id = NumberTool.safeToInteger(entity.getId(), 0);
            if (id != 0) {
                enumDao.update(entity);
            } else {
                enumDao.save(entity);
            }
        }
    }

    /**
     * 删除枚举
     *
     * @param idsStr 逗号分个的id字符串
     */
    @Override
    public void deleteEnum(String idsStr) {
        if (StringUtil.isNotBlank(idsStr)) {
            String[] idsArr = idsStr.split(",");
            for (String id : idsArr) {
                enumDao.delete(NumberTool.safeToInteger(id, 0));
            }
        }
    }

    /**
     * 根据模块和类型查询枚举
     *
     * @param catalog
     * @param type
     * @return
     */
    @Override
    public List<Map> getEnumByCatalogAndType(String catalog, String type) {
        return enumDao.selectByCatalogAndType(catalog, type);
    }
}
