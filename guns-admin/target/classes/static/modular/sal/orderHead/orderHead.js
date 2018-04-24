/**
 * 管理初始化
 */
var OrderHead = {
    id: "OrderHeadTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OrderHead.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键-订单主表', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '企业代码', field: 'enterpriseCode', visible: true, align: 'center', valign: 'middle'},
            {title: '要货单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
            {title: '物流单号', field: 'trackingNo', visible: true, align: 'center', valign: 'middle'},
            {title: '客户代码', field: 'customerCode', visible: true, align: 'center', valign: 'middle'},
            {title: '组织机构代码(管理组织机构)', field: 'orgCode', visible: true, align: 'center', valign: 'middle'},
            {title: '订单类型（1:分货订单，2:补货订单，3:加急订单）', field: 'orderType', visible: true, align: 'center', valign: 'middle'},
            {title: '订单状态(1-已发货，2-已收货)', field: 'orderStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '商品种类数量', field: 'goodsTypeQuantity', visible: true, align: 'center', valign: 'middle'},
            {title: '订单总金额', field: 'totalAmt', visible: true, align: 'center', valign: 'middle'},
            {title: '要求发货日期', field: 'preconsignDate', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '是否可用 1：可用', field: 'enableFlag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OrderHead.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrderHead.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
OrderHead.openAddOrderHead = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/orderHead/orderHead_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
OrderHead.openOrderHeadDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/orderHead/orderHead_update/' + OrderHead.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
OrderHead.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/orderHead/delete", function (data) {
            Feng.success("删除成功!");
            OrderHead.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orderHeadId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
OrderHead.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrderHead.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderHead.initColumn();
    var table = new BSTable(OrderHead.id, "/orderHead/list", defaultColunms);
    table.setPaginationType("client");
    OrderHead.table = table.init();
});
