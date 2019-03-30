package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.Enum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * enumDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 13:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EnumDaoTest {
    @Autowired
    private EnumDao enumDao;
    @Test
    public void selectById() throws Exception {
        System.out.println(enumDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        Enum entity=new Enum();
        entity.setCatalog("1");
        entity.setName("1");
        entity.setRemark("1");
        entity.setSort("1");
        entity.setType("1");
        entity.setValue("1");
        enumDao.save(entity);
    }

    @Test
    public void delete() throws Exception {
        enumDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        Enum entity=enumDao.selectById(1);
        entity.setCatalog("2");
        entity.setName("2");
        entity.setRemark("2");
        entity.setSort("2");
        entity.setType("2");
        entity.setValue("2");
        enumDao.update(entity);
    }

}