package com.xuhuan.mis.entity;

/**
 * 菜单
 *
 * @author huan.xu
 * @Time 2019-02-27 17:07
 */
public class Menu {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 排序
     */
    private String sort;
    /**
     * 上级菜单
     */
    private Integer parentId;

    /**
     * 样式图片
     */
    private String imgName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sort='" + sort + '\'' +
                ", parentId=" + parentId +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
