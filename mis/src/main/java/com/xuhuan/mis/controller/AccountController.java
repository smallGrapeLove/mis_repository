package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.AccountApply;
import com.xuhuan.mis.entity.AccountType;
import com.xuhuan.mis.service.IAccountService;
import com.xuhuan.mis.service.IEnumService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 账务controller
 *
 * @author huan.xu
 * @Time 2019-02-27 17:32
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IEnumService enumService;

    /**
     * 账务记录列表
     *
     * @param paramMap
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(ModelMap model, @RequestParam Map<String, String> paramMap) {
        List<Map> dataList=accountService.getAccountTableQuery(paramMap);
        model.addAttribute("dataList",dataList);

        return "account/account_list";
    }

    /**
     * 账户类型列表
     *
     * @param paramMap
     * @param model
     * @return
     */
    @RequestMapping(value = "/type/list", method = RequestMethod.GET)
    public String toTypeList(ModelMap model, @RequestParam Map<String, String> paramMap) {
        paramMap.put("enumCatalog", "account");
        paramMap.put("enumType", "accountType");
        List<Map> dataList = accountService.getTypeTableQuery(paramMap);
        model.addAttribute("dataList", dataList);
        model.addAttribute("paramMap", paramMap);

        List<Map> accountTypeEnumList = enumService.getEnumByCatalogAndType("account", "accountType");
        model.addAttribute("accountTypeEnumList", accountTypeEnumList);
        return "account/account_type_list";
    }

    /**
     * 跳转账务记录编辑
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable int id, ModelMap model, HttpServletRequest request) {
        if (id != 0) {
            AccountApply accountApply = accountService.getAccountApplyById(id);
            if (accountApply != null) {
                model.addAttribute("accountApply", accountApply);
                List<Map> accountDetailList = accountService.getAccountDetailByApplyId(id);
                if (accountDetailList != null && accountDetailList.size() > 0) {
                    List<Map> inDetailList = new ArrayList<>();
                    List<Map> outDetailList = new ArrayList<>();
                    for (Map detailMap : accountDetailList) {
                        String type = StringUtil.safeToString(detailMap.get("type"), "");
                        if ("1".equals(type)) {
                            detailMap.put("type","out");
                            outDetailList.add(detailMap);

                        } else if ("2".equals(type)) {
                            detailMap.put("type","in");
                            inDetailList.add(detailMap);
                        }
                    }
                    model.addAttribute("inDetailList", JSONArray.fromObject(inDetailList));
                    model.addAttribute("outDetailList", JSONArray.fromObject(outDetailList));
                }
            }
        }
        return "account/account_edit";
    }

    /**
     * 跳转账务类型编辑
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/type/toEdit/{id}", method = RequestMethod.GET)
    public String toTypeEdit(@PathVariable int id, ModelMap model, HttpServletRequest request) {
        if (id != 0) {
            model.addAttribute("id", id);
            AccountType accountType = accountService.getAccountTypeById(id);
            if (accountType != null) {
                model.addAttribute("accountType", accountType);
            }
        }
        List<Map> accountTypeEnumList = enumService.getEnumByCatalogAndType("account", "accountType");
        model.addAttribute("accountTypeEnumList", accountTypeEnumList);
        return "account/account_type_edit";
    }


    /**
     * 保存账务类型
     *
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/type/save", method = RequestMethod.POST)
    public String saveType(@RequestParam Map<String, String> paramMap) {
        accountService.saveTypeFormData(paramMap);
        return "redirect:/account/type/list";
    }

    /**
     * 保存账务记录
     *
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map<String, String> paramMap, HttpServletRequest request) {
        accountService.saveFormData(paramMap, request);
        return "redirect:/account/list";
    }

    /**
     * 删除角色
     *
     * @param request
     * @return
     */
    @RequestMapping("/type/delete")
    public String deleteType(HttpServletRequest request) {
        String ids = StringUtil.safeToString(request.getParameter("ids"), "");
        if (StringUtil.isNotBlank(ids)) {
            accountService.deleteAccountType(StringUtil.subEndFlag(ids, ","));
        }
        return "redirect:/account/type/list";
    }

    /**
     * 根据出入账类型查询账务类型
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAccountType", method = RequestMethod.POST)
    @ResponseBody
    public Object getAccountType(HttpServletRequest request) {
        String type = StringUtil.safeToString(request.getParameter("type"), "");
        List<Map> accountTypeList = accountService.getAccountTypeByType(type);
        return JSONArray.fromObject(accountTypeList);
    }
}
