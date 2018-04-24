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
 * @author stylefeng123
 * @since 2018-04-23
 */
@TableName("sal_order_head")
public class OrderHead extends Model<OrderHead> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键-订单主表
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
    /**
     * 物流单号
     */
    @TableField("tracking_no")
    private String trackingNo;
    /**
     * 客户代码
     */
    @TableField("customer_code")
    private String customerCode;
    /**
     * 组织机构代码(管理组织机构)
     */
    @TableField("org_code")
    private String orgCode;
    /**
     * 订单类型（1:分货订单，2:补货订单，3:加急订单）
     */
    @TableField("order_type")
    private Integer orderType;
    /**
     * 订单状态(1-已发货，2-已收货)
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 商品种类数量
     */
    @TableField("goods_type_quantity")
    private Integer goodsTypeQuantity;
    /**
     * 订单总金额
     */
    @TableField("total_amt")
    private BigDecimal totalAmt;
    /**
     * 要求发货日期
     */
    @TableField("preconsign_date")
    private Date preconsignDate;
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
    /**
     * 是否可用 1：可用
     */
    @TableField("enable_flag")
    private Integer enableFlag;


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

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getGoodsTypeQuantity() {
        return goodsTypeQuantity;
    }

    public void setGoodsTypeQuantity(Integer goodsTypeQuantity) {
        this.goodsTypeQuantity = goodsTypeQuantity;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Date getPreconsignDate() {
        return preconsignDate;
    }

    public void setPreconsignDate(Date preconsignDate) {
        this.preconsignDate = preconsignDate;
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

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OrderHead{" +
        "id=" + id +
        ", enterpriseCode=" + enterpriseCode +
        ", orderNo=" + orderNo +
        ", trackingNo=" + trackingNo +
        ", customerCode=" + customerCode +
        ", orgCode=" + orgCode +
        ", orderType=" + orderType +
        ", orderStatus=" + orderStatus +
        ", goodsTypeQuantity=" + goodsTypeQuantity +
        ", totalAmt=" + totalAmt +
        ", preconsignDate=" + preconsignDate +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", enableFlag=" + enableFlag +
        "}";
    }
}
