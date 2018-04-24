package com.stylefeng.guns.modular.system.view;


import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wfg123
 * @since 2018-04-23
 */

public class OrderItemView {



    /**
     * 主键-订单详情表
     */
    private Integer id;
    /**
     * 企业代码
     */
    private String enterpriseCode;
    /**
     * 要货单号
     */
    private String orderNo;
    private String customerCode;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 订货数量
     */
    private BigDecimal preconsignQuantity;

    /**
     * 收货数量
     */
    private BigDecimal receiptQuantity;
    /**
     * 计量单位编号
     */
    private String unitCode;
    /**
     * 计量单位名称
     */
    private String unitName;

    /**
     * forgin 要求发货日期
     */
    private Date preconsignDate;
    private String orderMergeType;

    private Double preconsignQuantitySum;

    private Double totalAmtSum;


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

    public Date getPreconsignDate() {
        return preconsignDate;
    }

    public void setPreconsignDate(Date preconsignDate) {
        this.preconsignDate = preconsignDate;
    }


    public String getOrderMergeType() {
        return orderMergeType;
    }

    public void setOrderMergeType(String orderMergeType) {
        this.orderMergeType = orderMergeType;
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
        "}";
    }

    public Double getPreconsignQuantitySum() {
        return preconsignQuantitySum;
    }

    public void setPreconsignQuantitySum(Double preconsignQuantitySum) {
        this.preconsignQuantitySum = preconsignQuantitySum;
    }

    public Double getTotalAmtSum() {
        return totalAmtSum;
    }

    public void setTotalAmtSum(Double totalAmtSum) {
        this.totalAmtSum = totalAmtSum;
    }
}
