/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.dao;

import org.springframework.stereotype.Repository;

import com.qingshixun.project.contact.model.ContactCategoryModel;

/**
 * 联系人分类处理 Dao 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */

@Repository("contactCategoryDao")
public class ContactCategoryDao extends BaseHibernateDao<ContactCategoryModel, Long> {

}
