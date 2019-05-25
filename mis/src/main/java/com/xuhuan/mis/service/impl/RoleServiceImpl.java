package com.xuhuan.mis.service.impl;


import com.xuhuan.mis.dao.RoleDao;
import com.xuhuan.mis.entity.Role;
import com.xuhuan.mis.service.IRoleService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 角色service实现类
 *
 * @author huan.xu
 * @Time 2019-02-27 17:21
 */
@Transactional
@Service("IRoleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 根据id查询角色信息
     *
     * @param id
     * @return
     */
    @Override
    public Role getRoleById(int id) {
        return roleDao.selectById(id);
    }

    /**
     * 保存角色信息
     *
     * @param paramMap
     */
    @Override
    public void saveFormData(Map paramMap) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String name = StringUtil.safeToString(paramMap.get("name"), "");
        String remark = StringUtil.safeToString(paramMap.get("remark"), "");

        Role role;
        if (id != 0) {
            role = this.getRoleById(id);
        } else {
            role = new Role();
        }
        role.setName(name);
        role.setRemark(remark);

        this.saveRole(role);

    }

    /**
     * 保存角色信息
     *
     * @param role
     */
    @Override
    public void saveRole(Role role) {
        if (role != null) {
            int id = NumberTool.safeToInteger(role.getId(), 0);
            if (id != 0) {
                roleDao.update(role);
            } else {
                roleDao.save(role);
            }
        }
    }

    /**
     * 列表查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Map> getTableQuery(Map searchMap) {
        return roleDao.selectByParam(searchMap);
    }

    /**
     * 删除角色
     *
     * @param idsStr 逗号分个的id字符串
     */
    @Override
    public void deleteRole(String idsStr) {
        if (StringUtil.isNotBlank(idsStr)) {
            String[] idsArr = idsStr.split(",");
            for (String id : idsArr) {
                roleDao.delete(NumberTool.safeToInteger(id, 0));
            }
        }
    }
}
