/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.contact.dao.ContactDao;
import com.qingshixun.project.contact.model.ContactModel;

/**
 * 联系人处理 Service 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Service
@Transactional
public class ContactService extends BaseService {

    // 注入联系人处理Dao
    @Autowired
    private ContactDao contactDao;

    /**
     * 获取所有联系人信息
     * 
     * @return
     */
    public List<ContactModel> getAllContacts() {
        return contactDao.getAll();
    }

    /**
     * 获取所有联系人信息
     * 
     * @return
     */
    public List<ContactModel> getContacts(Long contactCategoryId) {

        return contactDao.getContacts(contactCategoryId);
    }

    /**
     * 获取所有联系人信息
     * 
     * @return
     */
    public List<ContactModel> getFrequentContacts() {
        return contactDao.getFrequentContacts();
    }

    /**
     * 根据联系人ID，获取联系人信息
     * 
     * @param contactId
     * @return
     */
    public ContactModel getContact(Long contactId) {
        return contactDao.get(contactId);
    }

    /**
     * 保存联系人
     * 
     * @param contact
     */
    public void saveContact(ContactModel contact) {
        contactDao.save(contact);
    }

    /**
     * 删除联系人
     * 
     * @param contactId
     */
    public void deleteContact(Long contactId) {
        contactDao.delete(contactId);
    }
}
