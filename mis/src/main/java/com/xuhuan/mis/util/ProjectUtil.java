package com.xuhuan.mis.util;

import com.xuhuan.mis.util.common.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目中使用的公共方法
 *
 * @author huan.xu
 * @Time 2019-03-04 20:38
 */
public class ProjectUtil {

    /**
     * 获取时间字符串中的年月日
     *
     * @param dateStr 时间字符串
     * @param flag    年月日之间的标记
     * @return
     */
    public static Map getDateDetail(String dateStr, String flag) {
        Map dateDetailMap = new HashMap();
        String year = "";
        String month = "";
        String day = "";

        if (StringUtil.isNotBlank(dateStr)) {
            String[] details = dateStr.split(flag);
            year = details[0];
            month = details[1];
            day = details[2];
        }

        dateDetailMap.put("year", year);
        dateDetailMap.put("month", month);
        dateDetailMap.put("day", day);
        return dateDetailMap;
    }


}
