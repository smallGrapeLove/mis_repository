package com.xuhuan.mis.dao;


import com.xuhuan.mis.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * roleDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 9:34
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RoleDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testSelectById() {
        System.out.println(roleDao.selectById(1));
    }

    @Test
    public void testSave() {
        Role role = new Role();
        role.setName("name3");
        role.setRemark("remark3");
        roleDao.save(role);
    }

    @Test
    public void testDelete() {
        roleDao.delete(3);
    }

    @Test
    public void testUpdate() {
        Role role = roleDao.selectById(4);
        role.setRemark("new remark");
        roleDao.update(role);
    }

    @Test
    public void selectByParam() {
        Map searchMap = new HashMap<>();
//        searchMap.put("name","name");
        List<Map> roleList = roleDao.selectByParam(searchMap);
        for (Map role : roleList) {
            System.out.println("role[" + role.get("id") + "," + role.get("name") + "," + role.get("remark") + "]");
        }
    }
}