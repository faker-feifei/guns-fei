package com.stylefeng.guns.modular.sal.service.impl;

import com.stylefeng.guns.modular.system.dao.OrderItemMapper;
import com.stylefeng.guns.modular.system.model.OrderHead;
import com.stylefeng.guns.modular.system.dao.OrderHeadMapper;
import com.stylefeng.guns.modular.sal.service.IOrderHeadService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.view.OrderHeadView;
import com.stylefeng.guns.modular.system.view.OrderItemView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-04-23
 */
@Service
public class OrderHeadServiceImpl extends ServiceImpl<OrderHeadMapper, OrderHead> implements IOrderHeadService {

    @Resource
    private OrderItemMapper orderItemMapper;


    @Override
    public List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode, String customerCode, String orderMergeType) {

        List<OrderItemView> OrderItemList = orderItemMapper.selectMergeOrderListByDate(preconsignDate, enterpriseCode, customerCode, orderMergeType);

        OrderHeadView orderHeadView = null;
        String customerCode1 = "";
        String enterpriseCode1 = "";
        String orderMergeType1 = "";
        Long preconsignDate1 = -1L;
        int goodsTypeQuantity = 0;
        Double totalAmt = 0D;

        List<OrderHeadView> OrderHeadlist = new ArrayList<>();
        for(int i = 0, len = OrderItemList.size(); i < len; i++){

            OrderItemView orderItemView = OrderItemList.get(i);
            if(i == 0 || !(customerCode1.equals(orderItemView.getCustomerCode())
                    && enterpriseCode1.equals(orderItemView.getEnterpriseCode())
                    && orderMergeType1.equals(orderItemView.getOrderMergeType())
                    && preconsignDate1 == orderItemView.getPreconsignDate().getTime()
            )){
                if(i > 0){
                   //orderHeadView.setCustomerCode(customerCode1);
                   // orderHeadView.setEnterpriseCode(enterpriseCode1);
                   // orderHeadView.setOrderMergeType(orderMergeType1);
                    orderHeadView.setTotalAmt(new BigDecimal(totalAmt.toString()));
                    orderHeadView.setGoodsTypeQuantity(goodsTypeQuantity);
                    OrderHeadlist.add(orderHeadView);
                }
                orderHeadView = new OrderHeadView();
                BeanUtils.copyProperties(orderItemView, orderHeadView);
                goodsTypeQuantity = 0;
            }
            orderHeadView.getOrderItemList().add(orderItemView);

            customerCode1 = orderItemView.getCustomerCode();
            enterpriseCode1 = orderItemView.getEnterpriseCode();
            orderMergeType1 = orderItemView.getOrderMergeType();
            preconsignDate1 = orderItemView.getPreconsignDate().getTime();
            totalAmt += orderItemView.getTotalAmtSum();
            goodsTypeQuantity++;
            if(i+1 == len){
              //  orderHeadView.setCustomerCode(customerCode1);
              //  orderHeadView.setEnterpriseCode(enterpriseCode1);
              //  orderHeadView.setOrderMergeType(orderMergeType1);
                orderHeadView.setTotalAmt(new BigDecimal(totalAmt.toString()));
                orderHeadView.setGoodsTypeQuantity(goodsTypeQuantity);
                OrderHeadlist.add(orderHeadView);

            }
        }

        return OrderHeadlist;
    }

    @Override
    public List<OrderHeadView> selectMergeOrderList(String preconsignDate) {
        return this.selectMergeOrderList(preconsignDate, null);
    }

    @Override
    public List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode) {
        return this.selectMergeOrderList(preconsignDate, enterpriseCode,null);
    }

    @Override
    public List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode, String customerCode) {
        return this.selectMergeOrderList(preconsignDate, enterpriseCode, customerCode,null);
    }



}
