package com.xuhuan.mis.entity;

/**
 * 账务申请
 *
 * @author huan.xu
 * @Time 2019-02-27 17:13
 */
public class AccountApply {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 年份
     */
    private String year;
    /**
     * 月
     */
    private String month;
    /**
     * 日
     */
    private String day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "AccountApply{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
