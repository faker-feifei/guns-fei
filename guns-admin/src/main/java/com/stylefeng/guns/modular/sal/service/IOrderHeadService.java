package com.stylefeng.guns.modular.sal.service;

import com.stylefeng.guns.modular.system.model.OrderHead;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.view.OrderHeadView;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-04-23
 */
public interface IOrderHeadService extends IService<OrderHead> {


    List<OrderHeadView> selectMergeOrderList(String preconsignDate);
    List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode);
    List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode, String customerCode);
    List<OrderHeadView> selectMergeOrderList(String preconsignDate, String enterpriseCode, String customerCode, String orderMergeType);


}
