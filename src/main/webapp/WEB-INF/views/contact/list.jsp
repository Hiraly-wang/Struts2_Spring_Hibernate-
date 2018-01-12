﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<ul class="contact-list">
    <!-- 循环遍历和显示联系人列表 -->
	<c:forEach var="item" items="${contacts}">
		<li class="online">
			<div class="list-group-item">
				<div class="media">
					<div class="media-control">
						<button type="button" class="btn btn-info btn-sm" href="${ctx}/contact/edit.action?contactId=${item.id }" data-target="#contactFormContainer" data-toggle="modal">
							<i class="fa fa-pencil-square-o"></i> 编辑
						</button>
						<button type="button" class="delete-contact-btn btn btn-danger btn-sm" data-id="${item.id }">
							<i class="fa fa-trash-o"></i> 删除
						</button>
					</div>
					<div class="pull-left">
						<img class="img-circle" src="./images/contact${item.id }.jpg" alt="...">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							${item.name } <small>${item.position }</small>
						</h4>
						<div class="media-content">
							<i class="fa fa-map-marker"></i> ${item.address }
							<ul class="list-unstyled">
								<li>
									<i class="fa fa-user"></i> ${item.gender }
								</li>
								<li>
									<i class="fa fa-mobile"></i> ${item.mobile }
								</li>
								<li>
									<i class="fa fa-envelope-o"></i> ${item.email }
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>



