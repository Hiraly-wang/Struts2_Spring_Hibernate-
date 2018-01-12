/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.qingshixun.project.contact.model.ContactCategoryModel;
import com.qingshixun.project.contact.model.ContactModel;
import com.qingshixun.project.contact.service.ContactCategoryService;
import com.qingshixun.project.contact.service.ContactService;

/**
 * 联系人处理 Controller 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Namespace(value = "/contact")
public class ContactAction extends BaseAction {

    // 注入联系人分类处理 Service
    @Autowired
    private ContactCategoryService contactCategoryService;

    // 注入联系人处理 Service
    @Autowired
    private ContactService contactService;

    // 联系人ID
    private Long contactId;

    // 联系人分类ID
    private Long contactCategoryId;

    // 所有联系人分类
    private List<ContactCategoryModel> contactCategorys;

    // 联系人分类下的联系人
    private List<ContactModel> contacts;

    // 联系人的Model用于接收form表单传递过来的参数
    private ContactModel contactModel;

    /**
     * 获取所有联系人信息列表
     * 
     * @return
     */
    @Action(value = "list", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/contact/list.jsp") })
    public String listContact() {
        // 获取所有联系人信息
        contacts = contactService.getAllContacts();

        // 输出数据查询日志（调试使用）
        logger.debug(StringUtils.join(contacts, ","));

        return SUCCESS;
    }

    /**
     * 根据联系人分类，获取联系人信息列表
     * 
     * @return
     */
    @Action(value = "categoryList", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/contact/list.jsp") })
    public String listContactCategory() {
        // 根据联系人分类，获取所有联系人信息
        contacts = contactService.getContacts(contactCategoryId);

        return SUCCESS;
    }

    /**
     * 常用联系人列表
     * 
     * @return
     */
    @Action(value = "frequentList", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/contact/frequent.jsp") })
    public String listContactFrequent() {
        // 根据联系人分类，获取所有联系人信息
        contacts = contactService.getFrequentContacts();

        return SUCCESS;
    }

    /**
     * 新增联系人
     * 
     * @return
     */
    @Action(value = "add", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/contact/form.jsp") })
    public String addContactForm() {
        // 所有联系人分类信息
        contactCategorys = contactCategoryService.getAllContactCategorys();

        contactModel = new ContactModel();

        return SUCCESS;
    }

    /**
     * 编辑联系人
     * 
     * @return
     */
    @Action(value = "edit", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/contact/form.jsp") })
    public String editContactForm() {
        // 根据contactId，查询联系人信息
        contactModel = contactService.getContact(contactId);

        // 所有联系人分类信息
        contactCategorys = contactCategoryService.getAllContactCategorys();

        return SUCCESS;
    }

    /**
     * 保存联系人
     * 
     * @return
     */
    @Action(value = "save")
    public String saveContact() {
        logger.debug(StringUtils.join(contactModel.getEmail(), "contact"));
        try {
            // 执行保存联系人
            contactService.saveContact(contactModel);
            // 实现ajax请求往前台jsp中传递一个参数进行判断处理
            ServletActionContext.getResponse().getWriter().print("true");

        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 删除联系人列表
     * 
     * @return
     */
    @Action(value = "delete")
    public String deleteContact() {
        try {
            // 根据contactId，删除联系人
            contactService.deleteContact(contactId);
            // 实现ajax请求往前台jsp中传递一个参数进行判断处理
            ServletActionContext.getResponse().getWriter().print("true");

        } catch (Exception e) {
            // 异常处理
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return null;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getContactCategoryId() {
        return contactCategoryId;
    }

    public void setContactCategoryId(Long contactCategoryId) {
        this.contactCategoryId = contactCategoryId;
    }

    public List<ContactCategoryModel> getContactCategorys() {
        return contactCategorys;
    }

    public void setContactCategorys(List<ContactCategoryModel> contactCategorys) {
        this.contactCategorys = contactCategorys;
    }

    public List<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

}
