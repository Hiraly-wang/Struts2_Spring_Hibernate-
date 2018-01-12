/*******************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 * 
 * All rights reserved
 * 
 ******************************************************************************/

$(function() {
    // 加载联系人分类页面
    loadContactCategoryList();

    // 加载常用联系人页面
    loadFrequentContactList();

    // 加载联系人列表页面
    loadContactList();

    // 页面滚动条
    $("body").on("show.bs.modal", ".modal", function() {
        if ($(this).hasClass("modal-scroll")) {
            $("body").addClass("modal-open-noscroll");
        }
    });

    // 页面滚动条
    $("body").on("hide.bs.modal", ".modal", function() {
        $("body").removeClass("modal-open-noscroll");
    });

    // 将Ajax的内容和清除缓存模式关闭
    $("body").on("hidden.bs.modal", ".modal:not(.modal-cached)", function() {
        $(this).removeData("bs.modal");
    });

});

// 加载联系人分类页面
function loadContactCategoryList() {
    $("#contactCategoryPanel").load(rootPath + "/category/list.action", function(e) {
        var $contactCategoryItem = $(this).find(".contact-category-item");
        $contactCategoryItem.click(function(e) {
            var $this = $(this);
            // 获取联系人分类的id
            var contactCategoryId = $(this).data("id");

            // 加载分类下的联系人列表
            loadContactList(contactCategoryId, function(e) {
                // 删除选中样式
                $contactCategoryItem.removeClass("active");
                // 添加选中样式
                $this.addClass("active");
            });
        });
    });
}

// 加载常用联系人页面
function loadFrequentContactList() {
    $("#frequentListPanel").load(rootPath + "/contact/frequentList.action");
}

// 加载联系人列表页面
function loadContactList(contactCategoryId, callback) {
    var loadContactUrl = rootPath + "/contact/list.action";
    
    // 如果分类ID不为空且不为all加载分类下的联系人列表
    if (contactCategoryId != null && contactCategoryId != "all") {
        loadContactUrl = rootPath + "/contact/categoryList.action?contactCategoryId=" + contactCategoryId;
    }
    
    // 加载联系人列表页面
    $("#contactListPanel").load(loadContactUrl, function(e) {
        var $this = $(this);

        // 回调函数
        if (typeof callback == "function") {
            callback.call();
        }

        // 点击删除按钮响应删除事件
        $this.find(".delete-contact-btn").click(function(e) {
            var contactId = $(this).data("id");
            bootbox.confirm("是否确定删除此联系人？删除后不可以恢复的哦！", function(result) {
                if (result == true) {
                    // 传递联系人ID参数
                    var params = {
                        contactId : contactId
                    };
                    $.ajax({
                        type : "POST",
                        url : rootPath + "/contact/delete.action",
                        data : params,
                        dataType : "text",
                        success : function(strValue) {
                            console.log(strValue);
                            // 判断是否删除成功
                            if (strValue == "true") {
                                toastr.success("删除联系人成功！");
                                // 从新加载联系人列表
                                loadContactList();
                                // 从新加载常用联系人列表
                                loadFrequentContactList();
                            } else {
                                toastr.error("删除联系人失败：" + data.data);
                            }
                        }
                    });
                }
            });
        });
    });
}

// 关闭当前打开的ModalWindow
function closeModalWindow() {
    $(".modal-header button.close:last").trigger("click");
}
