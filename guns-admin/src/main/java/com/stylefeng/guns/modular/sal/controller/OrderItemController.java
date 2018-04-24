package com.stylefeng.guns.modular.sal.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.OrderItem;
import com.stylefeng.guns.modular.sal.service.IOrderItemService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-23 16:26:24
 */
@Controller
@RequestMapping("/orderItem")
public class OrderItemController extends BaseController {

    private String PREFIX = "/sal/orderItem/";

    @Autowired
    private IOrderItemService orderItemService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "orderItem.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/orderItem_add")
    public String orderItemAdd() {
        return PREFIX + "orderItem_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/orderItem_update/{orderItemId}")
    public String orderItemUpdate(@PathVariable Integer orderItemId, Model model) {
        OrderItem orderItem = orderItemService.selectById(orderItemId);
        model.addAttribute("item",orderItem);
        LogObjectHolder.me().set(orderItem);
        return PREFIX + "orderItem_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return orderItemService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(OrderItem orderItem) {
        orderItemService.insert(orderItem);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orderItemId) {
        orderItemService.deleteById(orderItemId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(OrderItem orderItem) {
        orderItemService.updateById(orderItem);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{orderItemId}")
    @ResponseBody
    public Object detail(@PathVariable("orderItemId") Integer orderItemId) {
        return orderItemService.selectById(orderItemId);
    }
}
