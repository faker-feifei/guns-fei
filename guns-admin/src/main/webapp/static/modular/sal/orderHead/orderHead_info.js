/**
 * 初始化详情对话框
 */
var OrderHeadInfoDlg = {
    orderHeadInfoData : {}
};

/**
 * 清除数据
 */
OrderHeadInfoDlg.clearData = function() {
    this.orderHeadInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderHeadInfoDlg.set = function(key, val) {
    this.orderHeadInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OrderHeadInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OrderHeadInfoDlg.close = function() {
    parent.layer.close(window.parent.OrderHead.layerIndex);
}

/**
 * 收集数据
 */
OrderHeadInfoDlg.collectData = function() {
    this
    .set('id')
    .set('enterpriseCode')
    .set('orderNo')
    .set('trackingNo')
    .set('customerCode')
    .set('orgCode')
    .set('orderType')
    .set('orderStatus')
    .set('goodsTypeQuantity')
    .set('totalAmt')
    .set('preconsignDate')
    .set('remark')
    .set('createTime')
    .set('updateTime')
    .set('enableFlag');
}

/**
 * 提交添加
 */
OrderHeadInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orderHead/add", function(data){
        Feng.success("添加成功!");
        window.parent.OrderHead.table.refresh();
        OrderHeadInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orderHeadInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OrderHeadInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/orderHead/update", function(data){
        Feng.success("修改成功!");
        window.parent.OrderHead.table.refresh();
        OrderHeadInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.orderHeadInfoData);
    ajax.start();
}

$(function() {

});
