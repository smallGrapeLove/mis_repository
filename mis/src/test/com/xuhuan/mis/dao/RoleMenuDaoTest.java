package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.RoleMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * roleMenuDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 14:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RoleMenuDaoTest {

    @Autowired
    private RoleMenuDao roleMenuDao;
    @Test
    public void selectById() throws Exception {
        System.out.println(roleMenuDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        RoleMenu roleMenu=new RoleMenu();
        roleMenu.setMenuId(1);
        roleMenu.setRoleId(1);
        roleMenuDao.save(roleMenu);
    }

    @Test
    public void delete() throws Exception {
        roleMenuDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        RoleMenu roleMenu=roleMenuDao.selectById(1);
        roleMenu.setMenuId(2);
        roleMenu.setRoleId(2);
        roleMenuDao.update(roleMenu);
    }

}