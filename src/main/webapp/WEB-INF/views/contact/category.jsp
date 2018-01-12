﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<li class="contact-category-item active" data-id="all">
	<a href="JavaScript:;"> 所有联系人 </a>
</li>
<!-- 循环遍历和显示联系人分类 -->
<c:forEach var="item" items="${contactCategorys}">
	<li class="contact-category-item" data-id="${item.id }">
		<a href="JavaScript:;"> ${item.name } </a>
	</li>
</c:forEach>
