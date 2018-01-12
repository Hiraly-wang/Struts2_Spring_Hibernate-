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

import com.qingshixun.project.contact.dao.ContactCategoryDao;
import com.qingshixun.project.contact.model.ContactCategoryModel;

/**
 * 联系人分类处理 Service 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Service("contactCategoryService")
@Transactional
public class ContactCategoryService extends BaseService {

    // 注入联系人分类处理Dao
    @Autowired
    private ContactCategoryDao contactCategoryDao;

    /**
     * 获取所有联系人分类信息
     * 
     * @return
     */
    public List<ContactCategoryModel> getAllContactCategorys() {
        return contactCategoryDao.getAll();
    }
}
