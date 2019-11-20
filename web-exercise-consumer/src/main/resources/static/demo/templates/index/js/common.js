var ajaxerr = function(XMLHttpRequest, textStatus, errorThrown) {
    if (textStatus == "timeout") {
        alert("请求超时");
    } else if (textStatus == "notmodified") {
        alert("Not-Modified");
    } else if (textStatus == "parsererror") {
        alert("从服务器返回的数据有误!");
    }
    isajax = true;
}
/*
* 返回链接指定属性的值
*/
var getQueryString = function(name) {
    var para = window.location.search;
    if (para != "") {
        para = decodeURIComponent(para.replace("?", ""));
    }
    var search = para.split("&");
    for (var i = 0, k = search.length; i < k; i++) {
        var str = search[i].split("=");
        if (str[0] == name) {
            return str[1];
        }
    }
    return "";
}

var inputNum = function(id) {
    $(id).bind("input propertychange", function() {
        var val = $(this).val();
        $(this).val(val.replace(/\D/g, '')); //匹配全局非数字为空
    });
}

var reWeak = function(num) {
    if (num == 0) {
        return "星期一";
    } else if (num == 1) {
        return "星期二";
    } else if (num == 2) {
        return "星期三";
    } else if (num == 3) {
        return "星期四";
    } else if (num == 4) {
        return "星期五";
    } else if (num == 5) {
        return "星期六";
    } else if (num == 6) {
        return "星期日";
    }
}


/////////////////////////////AJAX///////////////////////////////
/**
* 得到ajax对象
*/
function getajaxHttp() {
    var xmlHttp;
    try {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        // Internet Explorer
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("您的浏览器不支持AJAX！");
                return false;
            }
        }
    }
    return xmlHttp;
}
/**
* 发送ajax请求
* url--url
* methodtype(post/get)
* con (true(异步)|false(同步))
* parameter(参数)
* functionName(回调方法名，不需要引号,这里只有成功的时候才调用)
* (注意：这方法有二个参数，一个就是xmlhttp,一个就是要处理的对象)
* obj需要到回调方法中处理的对象
*/
function ajaxrequest(url, methodtype, con, parameter, functionName, obj) {
    var xmlhttp = getajaxHttp();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            //HTTP响应已经完全接收才调用
            functionName(xmlhttp, obj);
        }
    };
    xmlhttp.open(methodtype, url, con);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=gb2312");
    xmlhttp.send(parameter);
}
/////////////////////////////AJAX///////////////////////////////