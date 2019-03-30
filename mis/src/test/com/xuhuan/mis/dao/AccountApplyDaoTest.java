package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountApply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * accountApplyDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 13:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountApplyDaoTest {

    @Autowired
    private AccountApplyDao accountApplyDao;

    @Test
    public void selectById() throws Exception {
        AccountApply apply = accountApplyDao.selectById(1);
        System.out.println(apply);
    }

    @Test
    public void save() throws Exception {
        AccountApply apply=new AccountApply();
        apply.setYear("2018");
        apply.setMonth("12");
        apply.setDay("1");
        accountApplyDao.save(apply);
    }

    @Test
    public void delete() throws Exception {
        accountApplyDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        AccountApply apply = accountApplyDao.selectById(1);
        apply.setYear("2019");
        apply.setMonth("1");
        apply.setDay("2");
        accountApplyDao.update(apply);
    }

}