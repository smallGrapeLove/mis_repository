package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * accountTypeDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 13:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTypeDaoTest {

    @Autowired
    private AccountTypeDao accountTypeDao;
    @Test
    public void selectById() throws Exception {
        System.out.println(accountTypeDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        AccountType type=new AccountType();
        type.setName("1");
        type.setType("1");
        accountTypeDao.save(type);
    }

    @Test
    public void delete() throws Exception {
        accountTypeDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        AccountType type = accountTypeDao.selectById(1);
        type.setName("2");
        type.setType("2");
        accountTypeDao.update(type);
    }

}