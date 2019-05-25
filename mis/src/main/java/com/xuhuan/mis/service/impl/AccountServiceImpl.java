package com.xuhuan.mis.service.impl;

import com.xuhuan.mis.dao.AccountApplyDao;
import com.xuhuan.mis.dao.AccountDetailDao;
import com.xuhuan.mis.dao.AccountTypeDao;
import com.xuhuan.mis.entity.AccountApply;
import com.xuhuan.mis.entity.AccountDetail;
import com.xuhuan.mis.entity.AccountType;
import com.xuhuan.mis.service.IAccountService;
import com.xuhuan.mis.util.ProjectUtil;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 账务service实现类
 *
 * @author huan.xu
 * @Time 2019-02-27 17:24
 */
@Transactional
@Service("IAccountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountTypeDao accountTypeDao;

    @Autowired
    private AccountApplyDao accountApplyDao;

    @Autowired
    private AccountDetailDao accountDetailDao;

    /**
     * 账务类型列表查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Map> getTypeTableQuery(Map searchMap) {
        return accountTypeDao.selectByParam(searchMap);
    }

    /**
     * 根据id查询账务类型
     *
     * @param id
     * @return
     */
    @Override
    public AccountType getAccountTypeById(int id) {
        return accountTypeDao.selectById(id);
    }

    /**
     * 根据id查询账务申请
     *
     * @param id
     * @return
     */
    @Override
    public AccountApply getAccountApplyById(int id) {
        return accountApplyDao.selectById(id);
    }

    /**
     * 根据账务申请id查询账务明细
     *
     * @param id
     * @return
     */
    @Override
    public List<Map> getAccountDetailByApplyId(int id) {
        return accountDetailDao.selectByApplyId(id);
    }

    /**
     * 保存账务类型表单数据
     *
     * @param paramMap
     */
    @Override
    public void saveTypeFormData(Map paramMap) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String name = StringUtil.safeToString(paramMap.get("name"), "");
        String type = StringUtil.safeToString(paramMap.get("type"), "");

        AccountType accountType;
        if (id != 0) {
            accountType = this.getAccountTypeById(id);
        } else {
            accountType = new AccountType();
        }

        accountType.setName(name);
        accountType.setType(type);

        this.saveAccountType(accountType);
    }

    /**
     * 保存账户类型
     *
     * @param accountType
     */
    @Override
    public void saveAccountType(AccountType accountType) {
        if (accountType != null) {
            int id = NumberTool.safeToInteger(accountType.getId(), 0);
            if (id != 0) {
                accountTypeDao.update(accountType);
            } else {
                accountTypeDao.save(accountType);
            }
        }
    }

    /**
     * 根据出入账类型查询账务类型
     *
     * @param type
     * @return
     */
    @Override
    public List<Map> getAccountTypeByType(String type) {
        return accountTypeDao.selectByType(type);
    }

    /**
     * 保存账务记录表单数据
     *
     * @param paramMap
     */
    @Override
    @Transactional
    public void saveFormData(Map<String, String> paramMap, HttpServletRequest request) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String accountDate = StringUtil.safeToString(paramMap.get("accountDate"), "");

        AccountApply accountApply;
        if (id == 0) {
            accountApply = new AccountApply();
            Map dateDetail = ProjectUtil.getDateDetail(accountDate, "-");
            accountApply.setYear(StringUtil.safeToString(dateDetail.get("year"), ""));
            accountApply.setMonth(StringUtil.safeToString(dateDetail.get("month"), ""));
            accountApply.setDay(StringUtil.safeToString(dateDetail.get("day"), ""));
            accountApply.setAccountDate(accountDate);
            accountApplyDao.save(accountApply);
        } else {
            accountApply = accountApplyDao.selectById(id);
            //删除之前的账务记录
            accountDetailDao.deleteByApplyId(id);
        }
        //入账
        String[] hiddenInArr = (String[]) request.getParameterMap().get("hidden_in");
        if (hiddenInArr != null && hiddenInArr.length > 0) {
            for (String inIndex : hiddenInArr) {
                AccountDetail detail = new AccountDetail();
                detail.setApplyId(accountApply.getId());
                detail.setTypeId(NumberTool.safeToInteger(paramMap.get("type_in_" + inIndex), 0));
                detail.setPrice(NumberTool.safeToDouble(paramMap.get("price_in_" + inIndex), 0d));
                detail.setRemark(StringUtil.safeToString(paramMap.get("remark_in_" + inIndex), ""));
                accountDetailDao.save(detail);
            }
        }

        //出账
        String[] hiddenOutArr = (String[]) request.getParameterMap().get("hidden_out");
        if (hiddenOutArr != null && hiddenOutArr.length > 0) {
            for (String outIndex : hiddenOutArr) {
                AccountDetail detail = new AccountDetail();
                detail.setApplyId(accountApply.getId());
                detail.setTypeId(NumberTool.safeToInteger(paramMap.get("type_out_" + outIndex), 0));
                detail.setPrice(NumberTool.safeToDouble(paramMap.get("price_out_" + outIndex), 0d));
                detail.setRemark(StringUtil.safeToString(paramMap.get("remark_out_" + outIndex), ""));
                accountDetailDao.save(detail);
            }
        }


    }

    /**
     * 账务录入列表查询专用接口
     *
     * @param paramMap
     * @return
     */
    @Override
    public List<Map> getAccountTableQuery(Map<String, String> paramMap) {
        return accountApplyDao.selectTableQuery(paramMap);
    }

    /**
     * 删除账务类型
     *
     * @param idsStr 逗号分个的id字符串
     */
    @Override
    public void deleteAccountType(String idsStr) {
        if (StringUtil.isNotBlank(idsStr)) {
            String[] idsArr = idsStr.split(",");
            for (String id : idsArr) {
                accountTypeDao.delete(NumberTool.safeToInteger(id, 0));
            }
        }
    }


}
