package com.stylefeng.guns.modular.sal.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.view.OrderHeadView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.OrderHead;
import com.stylefeng.guns.modular.sal.service.IOrderHeadService;

import java.util.List;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-23 15:57:04
 */
@Controller
@RequestMapping("/orderHead")
public class OrderHeadController extends BaseController {

    private String PREFIX = "/sal/orderHead/";

    @Autowired
    private IOrderHeadService orderHeadService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "orderHead.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/orderHead_add")
    public String orderHeadAdd() {
        return PREFIX + "orderHead_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/orderHead_update/{orderHeadId}")
    public String orderHeadUpdate(@PathVariable Integer orderHeadId, Model model) {
        OrderHead orderHead = orderHeadService.selectById(orderHeadId);
        model.addAttribute("item",orderHead);
        LogObjectHolder.me().set(orderHead);
        return PREFIX + "orderHead_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return orderHeadService.selectList(null);
    }

    /**
     * 订单合并
     */
    @RequestMapping(value = "/orderMerge")
    @ResponseBody
    public List<OrderHeadView> OrderMerge(String preconsignDate, String enterpriseCode, String customerCode, String orderMergeType) {
        List<OrderHeadView> list = orderHeadService.selectMergeOrderList(preconsignDate, enterpriseCode, customerCode, orderMergeType);

        return list;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(OrderHead orderHead) {
        orderHeadService.insert(orderHead);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer orderHeadId) {
        orderHeadService.deleteById(orderHeadId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(OrderHead orderHead) {
        orderHeadService.updateById(orderHead);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{orderHeadId}")
    @ResponseBody
    public Object detail(@PathVariable("orderHeadId") Integer orderHeadId) {
        return orderHeadService.selectById(orderHeadId);
    }
}
