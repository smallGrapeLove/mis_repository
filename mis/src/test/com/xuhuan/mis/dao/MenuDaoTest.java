package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * menuDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 13:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MenuDaoTest {

    @Autowired
    private MenuDao menuDao;
    @Test
    public void selectById() throws Exception {
        System.out.println(menuDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        Menu menu=new Menu();
        menu.setName("1");
        menu.setParentId(1);
        menu.setSort("1");
        menu.setUrl("1");
        menuDao.save(menu);
    }

    @Test
    public void delete() throws Exception {
        menuDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        Menu menu=menuDao.selectById(1);
        menu.setName("2");
        menu.setParentId(2);
        menu.setSort("2");
        menu.setUrl("2");
        menuDao.update(menu);
    }

}