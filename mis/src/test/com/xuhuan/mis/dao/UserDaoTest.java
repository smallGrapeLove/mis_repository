package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * userDao测试
 *
 * @author huan.xu
 * @Time 2019-02-28 14:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void selectById() throws Exception {
        System.out.println(userDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        User user=new User();
        user.setShowName("1");
        user.setUserName("1");
        user.setPassword("1");
        user.setRoleId(1);
        userDao.save(user);
    }

    @Test
    public void delete() throws Exception {
        userDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        User user=userDao.selectById(1);
        user.setShowName("2");
        user.setUserName("2");
        user.setPassword("2");
        user.setRoleId(2);
        userDao.update(user);
    }

}