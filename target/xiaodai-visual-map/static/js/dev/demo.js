// demo 参数
var params = {"username": "test", "password": "123"};

/**
 * 使用jquery 发送一个ajax-get请求
 */
function doGet() {
    $.ajax({
        type: "GET",
        url: '/demo/get',
        success: function (html) {
            console.log(html);
        }
    });
}

/**
 * 使用jquery 发送一个ajax-post 请求，提交json数据
 */
function doPost() {
    $.ajax({
        type: "POST",
        url: '/demo/post',
        data: params,
        contentType: "application/json",
        success: function (data) {
            console.log(data);
        }
    });
}


/**
 * 使用jquery 发送一个ajax-post 请求，提交json数据
 */
function doPostQueryList() {
    var param = {
        "startTimeStr":"201403242055",
        "endTimeStr":"201403252055",
        "pageSize":100
    }
    $.ajax({
        type: "POST",
        url: '/visual/map/gps/datalist',
        data: JSON.stringify(param),
        contentType: "application/json",
        // dataType:"json",
        success: function (data) {
            console.log(data);
        }
    });
}