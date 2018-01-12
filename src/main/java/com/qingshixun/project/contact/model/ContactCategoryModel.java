/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 联系人分类实体类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Entity
@Table(name = "contact_category")
public class ContactCategoryModel extends IdModel {

    private static final long serialVersionUID = -5409123240965847159L;

    // 联系人分类名称（长度：100，不允许为空）
    @Column(length = 100, nullable = false)
    private String name;

    // 联系人分类下的所有相关联系
    @OneToMany(mappedBy = "category", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    // 根据联系人ID进行排序
    @OrderBy("id asc")
    private Set<ContactModel> contacts = new TreeSet<ContactModel>();

    // 基于 JSR303 BeanValidator 的校验规则
    @NotBlank(message = "联系人名称不允许为空！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
