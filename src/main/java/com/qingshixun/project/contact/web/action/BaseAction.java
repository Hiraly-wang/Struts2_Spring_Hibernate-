/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Controller 基类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public abstract class BaseAction extends ActionSupport {

    protected Logger logger = LoggerFactory.getLogger(getClass());
}
