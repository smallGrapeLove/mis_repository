package com.xuhuan.mis.service;

import com.xuhuan.mis.entity.AccountApply;
import com.xuhuan.mis.entity.AccountType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map; /**
 * 账务service
 * @author huan.xu
 * @Time 2019-02-27 17:22
 */
public interface IAccountService {
    /**
     * 账务类型列表查询
     * @param searchMap
     * @return
     */
    List<Map> getTypeTableQuery(Map searchMap);

    /**
     * 根据id查询账务类型
     * @param id
     * @return
     */
    AccountType getAccountTypeById(int id);

    /**
     * 根据id查询账务申请
     * @param id
     * @return
     */
    AccountApply getAccountApplyById(int id);

    /**
     * 根据账务申请id查询账务明细
     * @param id
     * @return
     */
    List<Map> getAccountDetailByApplyId(int id);

    /**
     * 保存账务类型表单数据
     * @param paramMap
     */
    void saveTypeFormData(Map paramMap);

    /**
     * 删除账务类型
     * @param idsStr 逗号分个的id字符串
     */
    void deleteAccountType(String idsStr);

    /**
     * 保存账户类型
     * @param accountType
     */
    void saveAccountType(AccountType accountType);

    /**
     * 根据出入账类型查询账务类型
     * @param type
     * @return
     */
    List<Map> getAccountTypeByType(String type);

    /**
     * 保存账务记录表单数据
     * @param paramMap
     */
    void saveFormData(Map<String, String> paramMap, HttpServletRequest request);

    /**
     * 账务录入列表查询专用接口
     * @param paramMap
     * @return
     */
    List<Map> getAccountTableQuery(Map<String, String> paramMap);
}
