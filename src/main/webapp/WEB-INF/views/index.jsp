<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="QingShiXun">
<title>联系人管理 轻实训-案例项目</title>

<!-- 引入样式文件 -->
<link href="styles/default.css" rel="stylesheet">

<script>
    var rootPath = "${ctx}";
</script>

</head>
<body>
	<div class="container">
		<div class="page-header">
			<div class="row">
				<div class="col-sm-8">
					<h3>
						<i class="fa fa-users"></i> <span class="">联系人管理 <small>轻实训-案例项目 (Struts MVC + Spring + Hibernate) 完全基于 Annotation 实现</small></span>
					</h3>
					<small>注：为了确保演示数据的完整性，后台服务端的“保存”和“删除”操作已经暂时禁用，即无法真正的保存和删除数据!</small>
				</div>
				<div class="col-sm-4">
					<h4>
						<img class="pull-right" src="${ctx }/images/logo-color.png">
					</h4>
				</div>
			</div>
		</div>
		<div id="contactMainPanel" class="content-panel">
			<div class="row">
				<div class="col-sm-3">
					<h4 class="xlg-title mb10">
						<i class="fa fa-th-list"></i> 联系人分类
					</h4>
					<ul id="contactCategoryPanel" class="nav nav-pills nav-stacked nav-contacts">
					</ul>
					<hr>
					<h4 class="xlg-title mb10">
						<i class="fa fa-star"></i> 常用联系人
					</h4>
					<div id="frequentListPanel" class="list-group people-group"></div>
				</div>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-6">
							<h3 id="contactListLabel" class="xlg-title">
								所有联系人 <a href="contact/add.action" data-target="#contactFormContainer" data-toggle="modal"> <i class="fa fa-plus"></i>
								</a>
							</h3>
						</div>
						<div class="col-sm-6">
							<div class="input-group pull-right">
								<input id="contactCenterSearch" type="text" placeholder="Search ...">
							</div>
						</div>
					</div>
					<div id="contactListPanel" class="list-group contact-group"></div>
				</div>

			</div>
		</div>
		<div class="modal fade" id="contactFormContainer" role="basic" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<img src="images/loading.gif" alt="" class="loading"> <span> &nbsp;&nbsp;亲，系统正在为你努力加载中... </span>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 加载第三方JavaScript插件 -->
	<script src="plugins/jquery-1.11.1.min.js"></script>
	<script src="plugins/bootstrap/bootstrap.min.js"></script>
	<script src="plugins/jquery.form.js"></script>
	<script src="plugins/icheck/icheck.js"></script>
	<script src="plugins/waitme/waitMe.js"></script>
	<script src="plugins/validate/jquery-html5Validate.js"></script>
	<script src="plugins/bootbox/bootbox.min.js"></script>
	<script src="plugins/bootstrap-toastr/toastr.js"></script>
	
	<!-- 加载应用JavaScript -->
	<script src="scripts/main.js"></script>
</body>
</html>