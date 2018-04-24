package com.stylefeng.guns.modular.system.view;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-04-23
 */

public class OrderHeadView  {

    private Integer id;
    /**
     * 企业代码
     */
    private String enterpriseCode;
    /**
     * 要货单号
     */
    private String orderNo;
    /**
     * 物流单号
     */
    private String trackingNo;
    /**
     * 客户代码
     */
    private String customerCode;
    /**
     * 组织机构代码(管理组织机构)
     */
    private String orgCode;
    /**
     * 订单类型（1:分货订单，2:补货订单，3:加急订单）
     */
    private Integer orderType;
    /**
     * 订单状态(1-已发货，2-已收货)
     */
    private Integer orderStatus;
    /**
     * 商品种类数量
     */
    private Integer goodsTypeQuantity;
    /**
     * 订单总金额
     */
    private BigDecimal totalAmt;
    /**
     * 要求发货日期
     */
    private Date preconsignDate;

    private String orderMergeType;


    private List<OrderItemView>  OrderItemList = new ArrayList<>();

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



    public List<OrderItemView> getOrderItemList() {
        return OrderItemList;
    }

    public void setOrderItemList(List<OrderItemView> orderItemList) {
        OrderItemList = orderItemList;
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
        "}";
    }

    public String getOrderMergeType() {
        return orderMergeType;
    }

    public void setOrderMergeType(String orderMergeType) {
        this.orderMergeType = orderMergeType;
    }
}
