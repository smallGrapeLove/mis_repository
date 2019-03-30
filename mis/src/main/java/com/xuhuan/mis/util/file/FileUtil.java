package com.xuhuan.mis.util.file;

import com.xuhuan.mis.util.common.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * 文件读取
 *
 * @author 徐欢
 * @Time 2017-07-19 9:21
 **/
public class FileUtil {

    private static String FILE_TYPE_TXT = "txt";
    private static String FILE_TYPE_XLSX = "xlsx";
    private static String FILE_TYPE_XLS = "xls";
    private static String ENCODING_UTF8 = "utf8";

    /**
     * 读取txt文件到string
     *
     * @param filePath
     * @return
     */
    public static String readTxtToString(String filePath) throws Exception {
        String txtContent = "";
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            if (getFileType(file).equalsIgnoreCase(FILE_TYPE_TXT)) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING_UTF8);
                BufferedReader bufferedReader = new BufferedReader(read);
                try {
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        txtContent += lineTxt + "\r";
                    }
                    read.close();
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return txtContent;
    }

    /**
     * 读取txt文件每一行到set中
     *
     * @param filePath
     * @return
     */
    public static Set<String> readTxtToSet(String filePath) throws Exception {
        Set<String> txtSet = new LinkedHashSet<String>();
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            if (getFileType(file).equalsIgnoreCase(FILE_TYPE_TXT)) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING_UTF8);
                BufferedReader bufferedReader = new BufferedReader(read);
                try {
                    String lineTxt = null;
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        txtSet.add(lineTxt);
                    }
                    read.close();
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return txtSet;
    }

    /**
     * 写txt文件
     *
     * @param filePath
     * @return
     */

    public static boolean writeToTxt(String content, String filePath) throws Exception {
        boolean flag = false;
        File file = new File(filePath);
        if (getFileType(file).equalsIgnoreCase(FILE_TYPE_TXT)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            String oldTxtContent = readTxtToString(filePath);
            FileOutputStream o = null;
            try {
                o = new FileOutputStream(file);
                //如果要写入的文件不为空，则追加要写入的内容到最后
                if (StringUtil.isNotBlank(oldTxtContent)) {
                    content = oldTxtContent + content;
                }
                o.write(content.getBytes(ENCODING_UTF8));
                o.close();
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new Exception("请传入正确的txt文件");
        }
        return flag;
    }

    /**
     * 获取文件类型
     *
     * @param file
     * @return
     */
    public static String getFileType(File file) throws Exception {
        String type = "";
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if (index != -1) {
            type = fileName.substring(index + 1, fileName.length());
        } else {
            throw new Exception("请传入文件");
        }
        return type;
    }

    /**
     * 获取文件去掉文件名的路径
     *
     * @param file
     * @return
     */
    public static String getFileParentPath(File file) {
        String path = file.getPath();
        return path.substring(0, path.lastIndexOf("\\"));
    }

    /**
     * 将F1复制到F2
     */
    public static void copyFile(File fromFile, File toFile) throws Exception {
        File fileParentPath = new File(getFileParentPath(toFile));
        if (!fileParentPath.exists()) {
            fileParentPath.mkdirs();
        }
        int length = 2097152;
        FileInputStream in = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] buffer = new byte[length];

        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.flush();
        out.close();
    }

}
