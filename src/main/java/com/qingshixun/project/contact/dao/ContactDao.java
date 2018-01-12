/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.contact.model.ContactModel;

/**
 * 联系人处理 Dao 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */

@Repository
public class ContactDao extends BaseHibernateDao<ContactModel, Long> {

    /**
     * 根据联系人分类，查询所有联系人信息
     * 
     * @param contactCategoryId
     * @return
     */
    public List<ContactModel> getContacts(Long contactCategoryId) {
        // 创建根据联系人分类查询条件
        Criterion contactCategoryCrt = createCriterion("category.id", contactCategoryId);

        // 查询，并返回查询到的联系人结果信息
        return find(contactCategoryCrt);
    }

    /**
     * 根据联系人分类，查询所有联系人信息
     * 
     * @param contactCategoryId
     * @return
     */
    public List<ContactModel> getFrequentContacts() {
        // 创建根据联系人分类查询条件
        Criterion contactCategoryCrt = createCriterion("isFrequent", true);

        // 查询，并返回查询到的联系人结果信息
        return find(contactCategoryCrt);
    }
}
