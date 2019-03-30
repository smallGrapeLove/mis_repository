package com.xuhuan.mis.entity;

/**
 * 账务明细
 *
 * @author huan.xu
 * @Time 2019-02-27 17:15
 */
public class AccountDetail {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 账务申请id
     */
    private Integer applyId;
    /**
     * 账务类型id
     */
    private Integer typeId;
    /**
     * 总价格
     */
    private Double price;
    /**
     * 描述
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                "id=" + id +
                ", applyId=" + applyId +
                ", typeId=" + typeId +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                '}';
    }
}
