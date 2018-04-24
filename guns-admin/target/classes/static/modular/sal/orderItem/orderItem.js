/**
 * 管理初始化
 */
var OrderItem = {
    id: "OrderItemTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OrderItem.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键-订单详情表', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '企业代码', field: 'enterpriseCode', visible: true, align: 'center', valign: 'middle'},
            {title: '要货单号', field: 'orderNo', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'customerCode', visible: true, align: 'center', valign: 'middle'},
            {title: '商品编码', field: 'goodsCode', visible: true, align: 'center', valign: 'middle'},
            {title: '商品名称', field: 'goodsName', visible: true, align: 'center', valign: 'middle'},
            {title: '订货数量', field: 'preconsignQuantity', visible: true, align: 'center', valign: 'middle'},
            {title: '收货数量', field: 'receiptQuantity', visible: true, align: 'center', valign: 'middle'},
            {title: '计量单位编号', field: 'unitCode', visible: true, align: 'center', valign: 'middle'},
            {title: '计量单位名称', field: 'unitName', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OrderItem.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OrderItem.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
OrderItem.openAddOrderItem = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/orderItem/orderItem_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
OrderItem.openOrderItemDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/orderItem/orderItem_update/' + OrderItem.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
OrderItem.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/orderItem/delete", function (data) {
            Feng.success("删除成功!");
            OrderItem.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("orderItemId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
OrderItem.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    OrderItem.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OrderItem.initColumn();
    var table = new BSTable(OrderItem.id, "/orderItem/list", defaultColunms);
    table.setPaginationType("client");
    OrderItem.table = table.init();
});
