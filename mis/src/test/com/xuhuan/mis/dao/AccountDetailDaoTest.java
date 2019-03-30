package com.xuhuan.mis.dao;

import com.xuhuan.mis.entity.AccountDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * accountDetailDao 测试
 *
 * @author huan.xu
 * @Time 2019-02-28 13:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountDetailDaoTest {

    @Autowired
    private AccountDetailDao detailDao;

    @Test
    public void selectById() throws Exception {
        System.out.println(detailDao.selectById(1));
    }

    @Test
    public void save() throws Exception {
        AccountDetail detail = new AccountDetail();
        detail.setApplyId(2);
        detail.setPrice(12.0);
        detail.setRemark("remark");
        detail.setTypeId(1);
        detailDao.save(detail);
    }

    @Test
    public void delete() throws Exception {
        detailDao.delete(1);
    }

    @Test
    public void update() throws Exception {
        AccountDetail detail = detailDao.selectById(1);
        System.out.println(detail);
        detail.setApplyId(2);
        detail.setTypeId(2);
        detail.setPrice(123.0);
        detail.setRemark("remark update");
        detailDao.update(detail);
    }

}