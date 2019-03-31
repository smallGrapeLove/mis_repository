package com.xuhuan.mis.service.impl;

import com.xuhuan.mis.constant.SystemConstant;
import com.xuhuan.mis.dao.UserDao;
import com.xuhuan.mis.entity.User;
import com.xuhuan.mis.service.IUserService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户service实现类
 *
 * @author huan.xu
 * @Time 2019-02-27 17:25
 */
@Service("IUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户
     *
     * @param paramMap
     */
    @Override
    public void saveFormData(Map paramMap) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String showName = StringUtil.safeToString(paramMap.get("showName"), "");
        String userName = StringUtil.safeToString(paramMap.get("userName"), "");
        int roleId = NumberTool.safeToInteger(paramMap.get("roleId"), 0);

        User entity;
        if (id != 0) {
            entity = this.getUserById(id);
        } else {
            entity = new User();
            entity.setPassword(SystemConstant.DEFAULT_PASSWORD);
        }

        entity.setShowName(showName);
        entity.setUserName(userName);
        entity.setRoleId(roleId);

        this.saveUser(entity);
    }

    /**
     * 列表查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Map> getTableQuery(Map searchMap) {
        return userDao.selectByParam(searchMap);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return userDao.selectById(id);
    }

    /**
     * 保存用户信息
     *
     * @param entity
     */
    @Override
    public void saveUser(User entity) {
        if (entity != null) {
            int id = NumberTool.safeToInteger(entity.getId(), 0);
            if (id != 0) {
                userDao.update(entity);
            } else {
                userDao.save(entity);
            }
        }
    }

    /**
     * 删除枚举
     *
     * @param idsStr 逗号分个的id字符串
     */
    @Override
    public void deleteUser(String idsStr) {
        if (StringUtil.isNotBlank(idsStr)) {
            String[] idsArr = idsStr.split(",");
            for (String id : idsArr) {
                userDao.delete(NumberTool.safeToInteger(id, 0));
            }
        }
    }

    /**
     * 根据登录名查找用户
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }


}
