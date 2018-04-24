package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.OrderItem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.view.OrderItemView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wfg123
 * @since 2018-04-23
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    List<OrderItemView> selectMergeOrderListByDate(@Param("preconsignDate")String preconsignDate,
                                                   @Param("enterpriseCode")String enterpriseCode,
                                                   @Param("customerCode")String customerCode,
                                                   @Param("orderMergeType")String orderMergeType);
}
