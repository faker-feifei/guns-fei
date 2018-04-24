package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wfg123
 * @since 2018-04-23
 */
@TableName("sal_order_item")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键-订单详情表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 企业代码
     */
    @TableField("enterprise_code")
    private String enterpriseCode;
    /**
     * 要货单号
     */
    @TableField("order_no")
    private String orderNo;
    @TableField("customer_code")
    private String customerCode;
    /**
     * 商品编码
     */
    @TableField("goods_code")
    private String goodsCode;
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;
    /**
     * 订货数量
     */
    @TableField("preconsign_quantity")
    private BigDecimal preconsignQuantity;
    /**
     * 收货数量
     */
    @TableField("receipt_quantity")
    private BigDecimal receiptQuantity;
    /**
     * 计量单位编号
     */
    @TableField("unit_code")
    private String unitCode;
    /**
     * 计量单位名称
     */
    @TableField("unit_name")
    private String unitName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPreconsignQuantity() {
        return preconsignQuantity;
    }

    public void setPreconsignQuantity(BigDecimal preconsignQuantity) {
        this.preconsignQuantity = preconsignQuantity;
    }

    public BigDecimal getReceiptQuantity() {
        return receiptQuantity;
    }

    public void setReceiptQuantity(BigDecimal receiptQuantity) {
        this.receiptQuantity = receiptQuantity;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
        "id=" + id +
        ", enterpriseCode=" + enterpriseCode +
        ", orderNo=" + orderNo +
        ", customerCode=" + customerCode +
        ", goodsCode=" + goodsCode +
        ", goodsName=" + goodsName +
        ", preconsignQuantity=" + preconsignQuantity +
        ", receiptQuantity=" + receiptQuantity +
        ", unitCode=" + unitCode +
        ", unitName=" + unitName +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
