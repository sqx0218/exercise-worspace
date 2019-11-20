var ydx = {
    ajax: {
        
    },
    notification: {        
        
    },
    shell: {        
        
    },
    documentReady:{
        
    },
    utils: {
        
    },
    pages: {
        
    }
};
Array.prototype.each = function (func) {
    for (var i = 0; i < this.length; i++) {
        var item = this[i];
        var result = func.call(item, i, item);
        if (result == false) {
            return;
        }
    }
};

Array.prototype.sum = function(propertyOrFunc) {
    var total = 0;
    var isFunc = typeof(propertyOrFunc) == "function";
    this.each(function() {
        if (isFunc) {
            total += propertyOrFunc.call(this);
        } else {
            var value = this[propertyOrFunc];
            if (value != undefined) {
                total += value * 1;
            }
        }
    });
    return total;
};

Array.prototype.where = function (predicateFunction) {
    var results = new Array();
    this.each(function() {
        if (predicateFunction.call(this)) {
            results.push(this);
        }
    });
    return results;
};

Array.prototype.orderBy = function (property, compare) {
    var items = this;
    for (var i = 0; i < items.length - 1; i++) {
        for (var j = 0; j < items.length - 1 - i; j++) {
            if (isFirstGreaterThanSecond(items[j], items[j + 1])) {
                var temp = items[j + 1];
                items[j + 1] = items[j];
                items[j] = temp;
            }
        }
    }
    function isFirstGreaterThanSecond(first, second) {
        if (compare != undefined) {
            return compare(first, second);
        }
        else if (property == undefined || property == null) {
            return first > second;
        }
        else {
            return first[property] > second[property];
        }
    }

    return items;
};

Array.prototype.orderByDescending = function (property, compare) {
    var items = this;
    for (var i = 0; i < items.length - 1; i++) {
        for (var j = 0; j < items.length - 1 - i; j++) {
            if (!isFirstGreaterThanSecond(items[j], items[j + 1])) {
                var temp = items[j + 1];
                items[j + 1] = items[j];
                items[j] = temp;
            }
        }
    }
    function isFirstGreaterThanSecond(first, second) {
        if (compare != undefined) {
            return compare(first, second);
        }
        else if (property == undefined || property == null) {
            return first > second;
        }
        else {
            return first[property] > second[property];
        }
    }
    return items;
};

Array.prototype.groupBy = function (predicate) {
    var results = [];
    var items = this;

    var keys = {}, index = 0;
    for (var i = 0; i < items.length; i++) {
        var selector;
        if (typeof predicate === "string") {
            selector = items[i][predicate];
        } else {
            selector = predicate(items[i]);
        }
        if (keys[selector] === undefined) {
            keys[selector] = index++;
            results.push({ key: selector, value: [items[i]] });
        } else {
            results[keys[selector]].value.push(items[i]);
        }
    }
    return results;
};

Array.prototype.skip = function (count) {
    var items = new Array();
    for (var i = count; i < this.length; i++) {
        items.push(this[i]);
    }
    return items;
};

Array.prototype.take = function (count) {
    var items = new Array();
    for (var i = 0; i < this.length && i < count; i++) {
        items.push(this[i]);
    }
    return items;
};

Array.prototype.firstOrDefault = function (predicateFunction) {
    if (this.length == 0) {
        return null;
    }
    if (predicateFunction == undefined) {
        return this[0];
    }
    var item = null;
    this.each(function () {
        if (predicateFunction.call(this)) {
            item = this;
            return false;
        }
        return true;
    });
    return item;
};

Array.prototype.any = function(predicateFunction) {
    if (predicateFunction == undefined) {
        return this.length > 0;
    }
    var hasAny = false;
    this.each(function() {
        if (predicateFunction.call(this)) {
            hasAny = true;
            return false;
        }
        return true;
    });
    return hasAny;
};

Array.prototype.select = function (predicateFunction) {
    if (predicateFunction == undefined) {
        throw "parameter predicateFunction cannot be null or undefined";
    }
    var items = [];
    this.each(function () {
        items.push(predicateFunction.call(this));
    });
    return items;
};

(function ($) {
    $.fn.busy = function (options) {

        var busyOptions = function (isbusy) {
            this.isBusy = isbusy;
            this.busyContent = "Loading...";
            this.request = null;
            this.showCancel = true;
            this.modal = true;
            this.delay = 0;
            this.css = "";
        };

        busyOptions.Fix = function (obj) {
            if (obj.constructor == Boolean) {
                return new busyOptions(obj);
            }
            var result = new busyOptions(true);
            for (property in obj) {
                result[property] = obj[property];
            }
            return result;
        };
        
        function createIndicator(opts) {
            var container = $("<div class='busy-indicator'></div>");
            if (opts.css != null && opts.css != "") {
                container.addClass(opts.css);
            }
            var contentWrapper = $("<div class='busy-content'></div>");
            contentWrapper.appendTo(container);
            if (opts.showCancel) {
                var cancelLink = $("<a href='javascript:void(0)' title='cancel' class='busy-cancel'></a>");
                cancelLink.appendTo(contentWrapper);
                cancelLink.click(function () {
                    if (opts.request != undefined && opts.request != null) {
                        opts.request.abort();
                    }
                    container.remove();
                });
            }
            $("<div class='busy-text'></div>").appendTo(contentWrapper);
            return container;
        }

        return $(this).each(function (i, elem) {
            var item = $(elem);
            options = busyOptions.Fix(options);
            var timer = null;
            if (options.isBusy) {
                var indicator = item.find(".busy-indicator");
                if (indicator.length == 0) {
                    indicator = createIndicator(options);
                    item.prepend(indicator);
                    var $content = item.find(".busy-content");
                    var contentHeight = $content.height();
                    var contentWidth = $content.width();
                    var windowHeight = $(window).height();
                    var windowWidth = $(window).width();
                    if (options.modal) {
                        indicator.addClass("busy-modal");
                        var itemHeight = item.height();
                        var itemWidth = item.width();
                        if (item.is("body")) {
                            indicator.css("position", "absolute");
                            var itemContentsHeight = 0;
                            var itemContentsWidth = 0;
                            if (item.find("#wrapper").length > 0) {
                                itemContentsHeight = item.find("#wrapper").height();
                                itemContentsWidth = item.find("#wrapper").width();
                            }
                            indicator.height(Math.max(itemHeight, windowHeight, itemContentsHeight) + "px");
                            indicator.width(Math.max(itemWidth, windowWidth, itemContentsWidth) + "px");
                            $content.css("position", "fixed");
                            contentWidth = $content.width();
                            $content.css("top", (windowHeight - contentHeight) / 2 + "px");
                            $content.css("left", (windowWidth - contentWidth) / 2 + "px");
                        } else {
                            indicator.height(itemHeight + "px");
                            indicator.width(itemWidth + "px");
                            $content.css("top", (indicator.height() - contentHeight) / 2 + "px");
                        }
                    }
                    else {
                        var wrapperHeight = 0;
                        var wrapperWidth = 0;
                        if (item.is("body")) {
                            indicator.css("position", "fixed");
                            wrapperHeight = windowHeight;
                            wrapperWidth = windowWidth;
                        } else {
                            wrapperHeight = item.height();
                            wrapperWidth = item.width();
                        }

                        var top = (wrapperHeight - contentHeight) / 2;
                        var left = (wrapperWidth - contentWidth) / 2;
                        indicator.css("left", left + "px");
                        indicator.css("top", top + "px");
                    }
                }
                indicator.find(".busy-text").html(options.busyContent);
                indicator.hide();

                timer = setTimeout(function () {
                    if (options.modal == false) {
                        indicator.css("display", "table");
                    }
                    else {
                        indicator.show();
                    }
                }, options.delay);
            } else {
                item.find(".busy-indicator").remove();
                clearTimeout(timer);
            }
        });
    };
})(jQuery);

$.busy = function(options) {
    $("body").busy(options);
};

$.toast = function (options) {
    var toastOptions = function (message) {
        this.message = message;
        this.showDuration = 500;
        this.displayDuration = 2000;
        this.hideDuration = 500;
        this.css = "";
        this.showClose = true;
    };

    toastOptions.Fix = function (obj) {
        if (obj.constructor == String) {
            return new toastOptions(obj);
        }
        var result = new toastOptions("");
        for (property in obj) {
            result[property] = obj[property];
        }
        return result;
    };


    options = toastOptions.Fix(options);
    var $toast = $("<div class='toast'>" + options.message + "</div>");
    if (options.css != "") {
        $toast.addClass(options.css);
    }
    $toast.appendTo("body");
    if (options.showClose) {
        var $close = $("<a class='close' href='javascript:void(0)'></a>");
        $close.appendTo($toast);
        $close.click(function() {
            $toast.animate({
                top: "-=35",
                opacity: 0
            }, {
                duration: options.hideDuration,
                complete: function () {
                    $toast.remove();
                }
            });
        });
    }
    var centerX = $(window).width() / 2;
    var centerY = $(window).height() / 2;
    var left = centerX - $toast.width() / 2;
    var top = centerY - $($toast).height() / 2 + 50;
    $toast.css("top", top + "px");
    $toast.css("left", left + "px");
    $toast.animate({
        top: "-=50",
        opacity: 1
    }, {
        duration: options.showDuration,
        complete: function () {
            setTimeout(function () {
                $toast.animate({
                    top: "-=35",
                    opacity: 0
                }, {
                    duration: options.hideDuration,
                    complete: function () {
                        $toast.remove();
                    }
                });
            }, options.displayDuration);
        }
    });
};


Date.prototype.addHours = function (number) {
    var date = new Date(this);
    date.setHours(date.getHours() + number);
    return date;
};

Date.prototype.addDays = function (number) {
    var date = new Date(this);
    date.setDate(date.getDate() + number);
    return date;
};

Date.prototype.addMonths = function (number) {
    var date = new Date(this);
    date.setMonth(date.getMonth() + number);
    return date;
};

Date.prototype.addYears = function (number) {
    var date = new Date(this);
    date.setFullYear(date.getFullYear() + number);
    return date;
};

Date.prototype.toWeekStart = function (startsFromSunday) {
    var dayOfWeek = this.getDay();
    if (startsFromSunday) {
        return this.addDays(-dayOfWeek);
    }
    if (dayOfWeek == 0) {
        dayOfWeek = 7;
    }
    return this.addDays(1 - dayOfWeek);
};

Date.prototype.toWeekEnd = function (startsFromSunday) {
    var dayOfWeek = this.getDay();
    if (startsFromSunday) {
        return this.addDays(6 - dayOfWeek);
    }
    if (dayOfWeek == 0) {
        dayOfWeek = 7;
    }
    return this.addDays(7 - dayOfWeek);
};

Date.prototype.toSunday = function () {
    var dayOfWeek = this.getDay();
    if (dayOfWeek == 0) {
        dayOfWeek = 7;
    }
    return this.addDays(7 - dayOfWeek);
};

Date.prototype.toMonday = function () {
    var dayOfWeek = this.getDay();
    if (dayOfWeek == 0) {
        return this.addDays(-6);
    }
    return this.addDays(1 - dayOfWeek);
};

Date.prototype.toMonthStart = function () {
    var date = new Date(this);
    date.setDate(1);
    return date;
};

Date.prototype.toMonthEnd = function () {
    var date = new Date(this);
    date.setMonth(date.getMonth() + 1);
    date.setDate(0);
    return date;
};

Date.prototype.toYearStart = function () {
    var date = new Date(this);
    date.setMonth(0);
    date.setDate(1);
    return date;
};

Date.prototype.toYearEnd = function () {
    var date = new Date(this);
    date.setMonth(12);
    date.setDate(0);
    return date;
};

Date.prototype.toUSDateString = function () {
    return (this.getMonth() + 1) + "/" + this.getDate() + "/" + this.getFullYear();
};

Date.prototype.toCNDateString = function () {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
};

Date.prototype.toChinaDateString = function () {
    return this.getFullYear() + "年" + (this.getMonth() + 1) + "月" + this.getDate() + "日";
};

Date.prototype.toTimeString = function () {
    var m = this.getMinutes();
    return this.getFullYear() + "/" + (this.getMonth() + 1) + "/" + this.getDate()
        + " " + this.getHours() + ":" + (m < 10 ? "0" : "") + m;
};

Date.prototype.toWeekString = function () {
    var weeks = ["周日", "周一", "周二", "周三", "周四", "周五", "周六"];
    return weeks[this.getDay()];
};

Date.prototype.toHHmm = function () {
    return Number.get2Digits(this.getHours()) + ":" + Number.get2Digits(this.getMinutes());
};

Date.prototype.toMonthNumber = function () {
    return this.getFullYear() * 100 + (this.getMonth() + 1);
};

Date.prototype.toWeekNumber = function () {
    return this.toSunday().toDateNumber();
};

Date.prototype.toDateNumber = function () {
    return this.toMonthNumber() * 100 + this.getDate();
};

Date.prototype.toHourNumber = function () {
    return this.toDateNumber() * 100 + this.getHours();
};

Date.prototype.toUSWeekString = function () {
    var weeks = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    return weeks[this.getDay()];
};

Date.prototype.toUSFullWeekString = function () {
    var weeks = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    return weeks[this.getDay()];
};

Date.parseFromJsonFormat = function (dateStr) {
    // "/Date(1383667450669)/"
    var str = dateStr.substring(6, dateStr.length - 2);
    return new Date(str * 1);
};

Date.parseFromDateNumber = function (number) {
    if (number.length <= 6) {
        number += "01";
    }
    if (number.length <= 8) {
        number += "00";
    }
    return new Date(
        number.substring(0, 4),
        number.substring(4, 6) * 1 - 1,
        number.substring(6, 8),
        number.substring(8, 10), 0, 0);
};

Date.parseFromDateTimeStr = function (datetime) {
    //2000-08-08 09:09:00
    return new Date(
        datetime.substring(0, 4),
        datetime.substring(5, 7),
        datetime.substring(8, 10),
        datetime.substring(11, 13),
        datetime.substring(14, 16),
        datetime.substring(17, 19)
    );
};
ydx.guid = {
    empty: function() {
        return '00000000-0000-0000-0000-000000000000';
    }
};
(function() {
    jQuery.prototype.cssDisable = function() {
        return this.each(function() {
            $(this).addClass("disabled");
        });
    };

    jQuery.prototype.cssEnable = function () {
        return this.each(function () {
            $(this).removeClass("disabled");
        });
    };
})();
if (!window.Number) {
    window.Number = function() {

    };
}

Number.get2Digits = function(number) {
    return number < 10 ? "0" + number : number;
};
var page = {
    widgets: {        
        
    },
    init: function() {
        this.onLoaded();
        for (var p in this.widgets) {
            var widget = this.widgets[p];
            widget.init && widget.init();
        }
    },
    onLoaded: function() {

    }
};

$(document).ready(function () {
    page.init();
});

ydx.ajax.busyPost = function (url, data, successCallBack, busyContent) {
    data.ajax = true;
	data.ts = new Date().getTime();
	//alert(data);return false;
    $.ajax({
        type: "post",
        url: url,
        //contentType: "application/x-www-form-urlencoded",
        data: data,
		dataType:'json',
        /*beforeSend: function (request) {
            if (busyContent && busyContent !== "") {
                var op = {
                    isBusy: true,
                    busyContent: busyContent == undefined ? '加载中...' : busyContent,
                    request: request,
                    showCancel: true,
                    delay: 500,
                    modal: true
                };
                $.busy(op);
            }
        },*/
        success: function (result) {
		//alert(result);return false;
            /*if (busyContent && busyContent !== "") {
                $.busy(false);
            }*/
            successCallBack(result);
        },
        error: function (err) {
            if (busyContent && busyContent !== "") {
                $.busy(false);
            }
            if (err.status!== 0) {
                ydx.notification.toastError("出错啦!");
            }
        }
    });
};

ydx.ajax.post = function (url, data, successCallBack) {
    data = "ajax=true&ts=" + new Date().getTime() + "&" + data;
    $.ajax({
        type: "post",
        url: url,
        contentType: "application/x-www-form-urlencoded",
        data: data,
        success: function (result) {
            successCallBack(result);
        },
        error: function (err) {
            if (err.status != 0) {
                ydx.notification.toastError("Error occurred!");
            }
        }
    });
};

ydx.ajax.load = function (wrapper, url, successCallback, message) {
    var $wrapper = $(wrapper);
    $wrapper.empty();
    message = message == undefined ? "加载中..." : message;
    $wrapper.html("<div class=='loading'>" + message + "</div>");
    var loadUrl;
    if (url.indexOf("?") < 0) {
        loadUrl = url + "?ajax=true&ts=" + new Date().getTime();
    } else {
        loadUrl = url + "&ajax=true&ts=" + new Date().getTime();
    }
    $.ajax({
        type: "get",
        url: loadUrl,
        success: function (result) {
            $wrapper.html(result);
            if (successCallback != undefined && successCallback != null) {
                successCallback();
            }
        },
        error: function () {
            $wrapper.html("<div class='load-error'><span class='error'>Error occuurred.</span><a href='javascript:void(0);'>Re-try</a></div>");
            $wrapper.find("a").click(function () {
                ydx.ajax.load(wrapper, url, successCallback);
            });
        }
    });
};

ydx.notification.toastSuccess = function (message) {
    $.toast({
        message: message,
        css: "success"
    });
};

ydx.notification.toast = function (message) {
    $.toast({
        message: message,
        css: "info"
    });
};

ydx.notification.toastError = function (message) {
    if (message == undefined || message == "") {
        message = "出错啦";
    }
    $.toast({
        message: message,
        css: "error",
        displayDuration: 3000
    });
};

ydx.notification.toastInfo = function (message) {
    $.toast({
        message: message,
        css: "info"
    });
};


ydx.notification.messageBox = function (title, content, buttons, onClose, width, height) {
    var id = "messagebox" + new Date().getTime();
    width = width == undefined ? 400 : width;
    height = height == undefined ? 250 : height;
    var $dialog = $("<div id='" + id + "' class='message-box'>" + content + "</div>");
    $dialog.appendTo("body");
    $dialog.dialog({
        modal: true,
        title: title,
        width: width,
        height: height,
        buttons: buttons,
        close: function () {
            $(this).dialog("destroy");
            if (onClose != undefined && onClose != null) {
                onClose();
            }
        }
    });
};

ydx.notification.alert = function (title, content, onClose, width, height) {
    ydx.notification.messageBox(title, content, {
        "OK": function () {
            $(this).dialog("close");
        }
    }, onClose, width, height);
};

ydx.notification.alertError = function (message, title) {
    if (title == undefined) {
        title = "出错啦";
    }
    if (message == undefined || message == '') {
        message = "糟了，服务器出错了~请再试试吧，如果一直出错，还可以联系客服解决哦！";
    }
    message = "<p class='error'>" + message + "</p>";
    ydx.notification.alert(title, message);
};

ydx.notification.dialog = function (id, title, options, destoryOnClose) {
    destoryOnClose = destoryOnClose == undefined ? true : destoryOnClose;
    var $dialog = $("#" + id);
    if ($dialog.length == 0) {
        $dialog = $("<div id='" + id + "' class='dialog' title='" + title + "'></div>").appendTo("body");
    }
    if (options.autoOpen == undefined) {
        options.autoOpen = false;
    }
    if (options.modal == undefined) {
        options.modal = true;
    }
    if (destoryOnClose) {
        if (options.close == undefined) {
            options.close = function () {
                $dialog.dialog("destroy");
                $dialog.remove();
            };
        } else {
            (function(closeFunc) {
                options.close = function () {
                    closeFunc();
                    $dialog.dialog("destroy");
                    $dialog.remove();
                };
            })(options.close);
        }
    }
    var createFunc = options.create;
    options.create = function() {
        createFunc && createFunc();
        //(function(idd) {
        //    setTimeout(function() {
        //        $('#' + idd).css("height", "auto");
        //    });
        //})(id);
    };
    $dialog.dialog(options);
    $dialog.dialog("open");
};
(function() {
    var urls = {
        myNotifications: '/me/me/notifications'
    };
    
    ydx.utils.bindDatePicker = function (input) {
        $(input).datepicker({
            dateFormat: "yy-m-d",
            monthNames: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
            dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"]
        });
    };

    ydx.utils.bindDatetimePicker = function(input) {
        $(input).datetimepicker();
    };

    ydx.utils.onEnterKeydown = function (inputSelector, callback) {
        $(inputSelector).keydown(function (e) {
            if (e.keyCode == 13) {
                callback();
            }
        });
    };

    ydx.utils.getCookieValue = function (name) {
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    };

    ydx.utils.removeCookie = function (name) {
        var value = this.getCookieValue(name);
        if (value != null) {
            var exp = new Date();
            exp.setFullYear(2000);
            document.cookie = name + "=" + value + ";path=/;expires=" + exp.toGMTString();
        }
    };

    ydx.utils.setCookie = function (name, value, expire) {
        document.cookie = name + "=" + value + ";path=/;expires=" + expire.toGMTString();
    };

    ydx.utils.setCityUrlKeyCookie = function (key) {
        var arr = window.location.host.split(".");
        var topHost = arr[arr.length - 2] + "." + arr[arr.length - 1];
        document.cookie = "urlcitykey=" + key + ";domain=" + topHost + ";path=/;expires=" + (new Date()).addDays(300).toGMTString();
    };

    ydx.utils.centerDialog = function (selector) {
        var $dialogs = selector ? $(selector).closest(".ui-dialog") : $(".ui-dialog:visible");
        $dialogs.each(function () {
            var $dialog = $(this);
            var height = $dialog.height();
            var winHeight = $(window).height();
            var top = (winHeight - height) / 2;
            top = Math.max(top, 0);
            $dialog.animate({ top: top }, 200);
        });
    };

    ydx.utils.parseUnobtrusive = function (formSelector) {
        $.validator.unobtrusive.parse($(formSelector));
    };
    
    ydx.utils.getCityName = function(successCallback, errorCallback, timeout) {
        navigator.geolocation.getCurrentPosition(function(position) {
            try {
                if (window.BMap == undefined) {
                    successCallback && successCallback({
                        cityName: "",
                        isCenterPoint: false,
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    });
                    return;
                }
                var point = new BMap.Point(position.coords.longitude, position.coords.latitude);
                var gc = new BMap.Geocoder();
                gc.getLocation(point, function(rs) {
                    var addComp = rs.addressComponents;
                    successCallback && successCallback({
                        cityName: addComp.city,
                        isCenterPoint: false,
                        lat: position.coords.latitude,
                        lng: position.coords.longitude
                    });
                });
            } catch(e) {
                errorCallback && errorCallback();
            }
        },
            function () {
                if (window.BMap == undefined) {
                    errorCallback && errorCallback();
                    return;
                }
                try {
                    var myCity = new BMap.LocalCity();
                    myCity.get(function(result) {
                        successCallback && successCallback({
                            cityName: result.name,
                            isCenterPoint: true,
                            lat: result.center.lat,
                            lng: result.center.lng
                        });
                    });
                } catch(e) {
                    errorCallback && errorCallback();
                }
            }, {
                timeout: timeout || 1500,
                enableHighAccuracy: true
            });
    };

    ydx.utils.locateAndRedirect = function (isAuto) {
        var sld = ydx.utils.getSecondLevelDomain();
        var cookieSld = ydx.utils.getCookieValue("urlcitykey");
        var cqSld = ["", "cq"];
        var specials = ["dev", "api"];
        if (cookieSld != null) {
            if (specials.indexOf(sld) >= 0) {
                ydx.utils.setCityUrlKeyCookie("");
                return;
            } else if (sld == cookieSld) {
                return;
            } else if ((cqSld.indexOf(sld) >= 0 && cqSld.indexOf(cookieSld) >= 0)) {
                ydx.utils.setCityUrlKeyCookie("");
                return;
            } else {
                if (isAuto) {
                    if (sld) {
                        ydx.utils.setCityUrlKeyCookie(sld);
                    } else {
                        ydx.utils.setCityUrlKeyCookie(cookieSld);
                        window.location = ydx.utils.replaceSecondLevelDomain(cookieSld);
                    }
                    return;
                }
            }
        }
        var confirmCity = function (cityDto) {
            var key = (cityDto.Key + "").toLowerCase();
            if (key == sld || (key == "cq" && sld == "")) {
                ydx.utils.setCityUrlKeyCookie(sld);
            } else {
                if ($.prototype.dialog != undefined) {
                    var id = "changecitydialog" + new Date().getTime();
                    var $dialog = $("<div id='" + id + "' class='message-box'>" + "定位到您的城市为[" + cityDto.Name + "],是否需要切换到该城市?" + "</div>");
                    $dialog.appendTo("body");
                    $dialog.dialog({
                        modal: true,
                        title: "切换城市",
                        width: 300,
                        height: 150,
                        buttons: {
                            "切换": function () {
                                $(this).dialog("destroy");
                                ydx.utils.setCityUrlKeyCookie(cityDto.Key);
                                window.location = ydx.utils.replaceSecondLevelDomain(cityDto.Key);
                            },
                            "取消": function () {
                                $(this).dialog("destroy");
                                ydx.utils.setCityUrlKeyCookie(sld);
                            }
                        },
                        close: function () {
                            $(this).dialog("destroy");
                            ydx.utils.setCityUrlKeyCookie(sld);
                        }
                    });
                    return;
                }
                if (confirm("定位到您的城市为<" + cityDto.Name + ">,是否需要切换到该城市?")) {
                    ydx.utils.setCityUrlKeyCookie(cityDto.Key);
                    window.location = ydx.utils.replaceSecondLevelDomain(cityDto.Key);
                } else {
                    ydx.utils.setCityUrlKeyCookie(sld);
                }
            }
        };
        ydx.utils.getCityName(function (data) {
            if (data.cityName) {
                ydx.ajax.post("/Others/getCitySLDKey", "cityName=" + data.cityName, function (result) {
                    if (result.Success && result.Value) {
                        confirmCity(result.Value);
                    }
                });
            }
        }, function () {
            ydx.utils.setCityUrlKeyCookie(sld);
        });
    };

    ydx.utils.getSecondLevelDomain = function() {
        var host = window.location.host.toLowerCase();
        var arrMinLength = 3;
        if (host.indexOf("www.") == 0) {
            arrMinLength = 4;
        }
        var domainArray = host.split(".");
        if (domainArray.length >= arrMinLength) {
            return domainArray[domainArray.length - 3];
        }
        return "";
    };

    ydx.utils.replaceSecondLevelDomain = function(key) {
        var host = window.location.host.toLowerCase();
        var newHost = "";
        var isHostStartWhitWww = false;
        if (host.indexOf("www.") == 0) {
            isHostStartWhitWww = true;
            host.replace("www.", "");
        }
        var domainArray = host.split(".");
        if (domainArray.length >= 3) {
            newHost = domainArray[domainArray.length - 2] + "." + domainArray[domainArray.length - 1];
        } else {
            newHost = host;
        }
        var url = window.location.protocol+"//" + (isHostStartWhitWww ? "www." : "") + (key ? (key + ".") : "") + newHost + window.location.pathname;
        return url;
    };

    var isAuthenticated = null;
    ydx.utils.isAuthenticated = function () {
        if (isAuthenticated == null) {
            isAuthenticated = $("#linkPublicLogout").length > 0;
        }
        return isAuthenticated;
    };

    ydx.utils.refreshMyNotifications = function () {
        if (this.isAuthenticated() == false) {
            return;
        }
        var $linkMyOrder = $("#linkMyOrder");
        var $linkMyMessage = $("#linkMyMessage");
        ydx.ajax.post(urls.myNotifications, null, function (result) {
            if (result.Success) {
                if (result.Value.UnreadMessages > 0) {
                    $linkMyMessage.html('我的动美(<span class="pending">' + result.Value.UnreadMessages + '</span>)');
                } else {
                    $linkMyMessage.html('我的动美');
                }
                if (result.Value.UnpaidOrders > 0) {
                    $linkMyOrder.html('我的订单(<span class="pending">' + result.Value.UnpaidOrders + '</span>)');
                } else {
                    $linkMyOrder.html('我的订单');
                }
            }
        });
    };
})();
(function() {
    ydx.documentReady.bindAddFav = function() {
        $("#linkAddFav").click(function() {
            var url = 'http://www.sport7.cn';
            var title = '动美网';

            try {
                window.external.addFavorite(url, title);
            } catch (e) {
                try {
                    window.sidebar.addPanel(title, url, "");
                } catch (e) {
                    alert("抱歉，您所使用的浏览器无法完成此操作。\n\n加入收藏失败，请使用Ctrl+D进行添加");
                }
            }
        });
    };

    ydx.documentReady.autoRefreshNotifications = function() {
        ydx.utils.refreshMyNotifications();
        setInterval(function() {
            ydx.utils.refreshMyNotifications();
        }, 60000);
    };

    ydx.documentReady.bindGlobalSearch = function() {
        $("#headerContent #btnGlobalSearch").click(function (e) {
            e.preventDefault();
            doSearch();
        });
        ydx.utils.onEnterKeydown("#headerContent #txtGlobalSearch", function () {
            doSearch();
        });

        function doSearch() {
            var key = $("#headerContent #txtGlobalSearch").val();
            //window.location = "/search/" + key;
            var categoryKey = $('#CategoryKey').val();
            if (categoryKey == "") {
                categoryKey = "all";
            }
            if (key == "") {
                window.location = "/search/" + categoryKey + ".html";
            } else {
                window.location = "/search/" + categoryKey + "/" + key + ".html";
            }
        }
    };

    ydx.documentReady.bindSwitchCity = function() {
        var $btn = $("#linkCity .relative");
        if ($btn.length > 0) {
            $btn.click(function (e) {
                e.stopPropagation();
                var $city = $("#linkCity");
                if ($city.hasClass("open")) {
                    $city.removeClass("open");
                } else {
                    $city.addClass("open");
                }
            });
            $("body").click(function() {
                $("#linkCity").removeClass("open");
            });
        }
    };


    ydx.documentReady.bindSwitchSport = function () {
        $("#linkSport").mouseover(function () {
            $(this).addClass("open");
        });
        $("#linkSport").mouseout(function () {
            $(this).removeClass("open");
        });
        $("#linkSport").on("click", "a", function () {

            var $li = $(this).closest("li");
            $li.siblings().removeClass("selected");
            $li.addClass("selected");

            $("#CategoryKey").val($("#linkSport li.selected").attr("data-id"));
            $("#selectedSport").html($("#linkSport li.selected").attr("title"));

            var $sport = $("#linkSport");
            $sport.removeClass("open");
        });
        $("body").click(function () {
            $("#linkSport").removeClass("open");
        });
    };

    ydx.documentReady.bindThreeDBtnDisabledShake = function () {
        $(document).on("click", ".three-d.disabled", function () {
            var $this = $(this);
            $this.addClass("clicked");
            setTimeout(function () {
                $this.removeClass("clicked");
            }, 300);
        });
    };

})();

$(document).ready(function () {
    for (var handler in ydx.documentReady) {
        ydx.documentReady[handler]();
    }
    $(".header > .btn-back").on("click", function () {
        var $this = $(this);
        if ($this.attr("href") == "javascript:;" || $this.attr("href") == "javascript:void(0);") {
            var lastIndex = document.referrer.lastIndexOf(window.location.host);
            if (lastIndex >= 0 && lastIndex <= 8) {  // "http://","https://",""
                history.go(-1);
            } else {
                var href = $this.attr("data-topurl");
                if (href) {
                    window.location = href;
                } else {
                    var url = (window.location.pathname + "").toLowerCase();
                    if (url.indexOf("/app/") == 0 || url.indexOf("/m/") == 0) {
                        window.location = "/app";
                    } else if (url.indexOf("/cm/") == 0) {
                        window.location = "/cm";
                    }
                }
            }
        }
    });
    $(".header > #spanChangeCity").click(function () {
        window.location = "/m/city?from=" + encodeURI(window.location.pathname);
    });
    $("#linkCity>ul li a").click(function () {
        var key = $(this).attr("data-key");
        if (key != undefined) {
            ydx.utils.setCityUrlKeyCookie(key);
        }
    });
});