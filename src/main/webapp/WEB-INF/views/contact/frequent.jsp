<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- 循环遍历和显示常用联系人列表 -->
<c:forEach var="item" items="${contacts}">
	<div class="list-group-item">
		<div class="media">
			<div class="pull-left">
				<img class="img-circle" src="./images/contact${item.id }.jpg" alt="...">
			</div>
			<div class="media-body">
				<h4 class="media-heading">${item.name }</h4>
				<small>${item.mobile }</small>
			</div>
		</div>
	</div>
</c:forEach>
