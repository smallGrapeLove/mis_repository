package com.xuhuan.mis.util.common;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串工具类
 *
 * @author huan.xu
 * @Time 2019-2-13
 */
public class StringUtil {

    public static boolean isStrEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static String safeToString(Object o, String dv) {
        String r = dv;
        if (o != null) {
            r = String.valueOf(o);
            if (StringUtils.isBlank(r)) {
                r = dv;
            }
        }

        return r;
    }

    /**
     * 去掉字符串最后的某个标记
     *
     * @param str
     * @param flag
     * @return
     */
    public static String subEndFlag(String str, String flag) {
        if (StringUtil.isNotBlank(str)) {
            if (StringUtil.isNotBlank(flag)) {
                if (str.endsWith(flag)) {
                    return str.substring(0,str.length() - flag.length());
                }
            } else {
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args){
        System.out.println(subEndFlag("1,2,",","));
    }
}
