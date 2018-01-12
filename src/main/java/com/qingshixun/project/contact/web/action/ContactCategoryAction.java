/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qingshixun.project.contact.model.ContactCategoryModel;
import com.qingshixun.project.contact.service.ContactCategoryService;

/**
 * 联系人分类处理 Controller 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Namespace(value = "/category")
public class ContactCategoryAction extends BaseAction {

    // 注入联系人分类处理 Service
    @Autowired
    private ContactCategoryService contactCategoryService;

    // 联系人分类列表
    private List<ContactCategoryModel> contactCategorys;

    /**
     * 联系人分类列表
     * 
     * @return
     */
    @Action(value = "list", results = { @Result(name = "success", location = "/WEB-INF/views/contact/category.jsp") })
    public String listCategory() {
        // 调用联系人分类Service，获取所有联系人分类数据
        contactCategorys = contactCategoryService.getAllContactCategorys();

        return SUCCESS;
    }

    public List<ContactCategoryModel> getContactCategorys() {
        return contactCategorys;
    }

    public void setContactCategorys(List<ContactCategoryModel> contactCategorys) {
        this.contactCategorys = contactCategorys;
    }

}
