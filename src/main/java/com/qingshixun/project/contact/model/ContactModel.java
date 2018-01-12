/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 联系人实体类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Entity
@Table(name = "contact")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ContactModel extends IdModel {

    private static final long serialVersionUID = 778636599754603525L;

    // 性别(枚举值)
    public enum Gender {
        Male, Female;
    }

    // 联系人姓名
    @Column(length = 100, nullable = false)
    private String name;

    // 联系人性别
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender = Gender.Male;

    // 联系人手机
    @Column(length = 15)
    private String mobile;

    // 联系人地址
    @Column(length = 255)
    private String address;

    // 联系人邮箱
    @Column(length = 255)
    private String email;

    // 联系人职位
    @Column(length = 255)
    private String position;

    // 是否为常用联系人
    @Column
    private boolean isFrequent = false;

    // 联系人分类
    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "category_id")
    private ContactCategoryModel category;

    // 基于 JSR303 BeanValidator 的校验规则
    @NotBlank(message = "联系人名称不允许为空！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ContactCategoryModel getCategory() {
        return category;
    }

    public void setCategory(ContactCategoryModel category) {
        this.category = category;
    }

    public boolean getIsFrequent() {
        return isFrequent;
    }

    public void setIsFrequent(boolean isFrequent) {
        this.isFrequent = isFrequent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
