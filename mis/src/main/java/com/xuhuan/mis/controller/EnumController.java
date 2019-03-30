package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.Enum;
import com.xuhuan.mis.service.IEnumService;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 枚举controller
 *
 * @author huan.xu
 * @Time 2019-02-27 17:32
 */
@Controller
@RequestMapping("/enum")
public class EnumController {

    @Autowired
    private IEnumService enumService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(ModelMap model, @RequestParam Map paramMap) {
        List<Map> dataList = enumService.getTableQuery(paramMap);
        model.addAttribute("dataList", dataList);
        model.addAttribute("paramMap",paramMap);
        return "enum/enum_list";
    }

    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable int id, ModelMap modelMap, HttpServletRequest request) {
        if (id != 0) {
            modelMap.addAttribute("id", id);
            Enum entity = enumService.getEnumById(id);
            if (entity != null) {
                modelMap.addAttribute("entity", entity);
            }
        }
        return "enum/enum_edit";
    }

    /**
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map paramMap) {
        enumService.saveFormData(paramMap);
        return "redirect:/enum/list";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        String ids = StringUtil.safeToString(request.getParameter("ids"), "");
        if(StringUtil.isNotBlank(ids)){
            enumService.deleteEnum(StringUtil.subEndFlag(ids,","));
        }
        return "redirect:/enum/list";
    }
}
