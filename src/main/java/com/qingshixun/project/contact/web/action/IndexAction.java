/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * 首页处理 Controller 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */

//@ParentPackage("struts-default")  //表示继承的父包 
@Namespace(value = "/")
public class IndexAction extends BaseAction {

    @Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp") }, exceptionMappings = { @ExceptionMapping(exception = "java.lang.Exception", result = "error") })
    public String index() {
        return SUCCESS;
    }

}
