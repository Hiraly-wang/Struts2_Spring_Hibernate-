<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/common/taglibs.jsp"%>
<script>
    $(function() {
        var $contactForm = $("#contactForm");

        //联系人Form提交参数设置（基于jquery.form.js插件）
        var submitFormOptions = {
            url : rootPath + "/contact/save.action",
            type : "POST",
            success : function(data) {
                //保存成功
                if (data == "true") {
                    toastr.success("保存联系人成功！");
                    //关闭Form窗口
                    closeModalWindow();
                    //重新加载联系人列表
                    loadContactList();
                    //重新加载常用联系人列表
                    loadFrequentContactList();
                } else {
                    toastr.error("保存联系人失败：" + data.data);
                }
            },
            error : function(context, xhr) {
                toastr.error("保存联系人失败：" + context.responseText);
            }
        };

        //联系人保存提交验证
        $contactForm.html5Validate(function() {
            //验证通过执行保存操作
            $(this).ajaxSubmit(submitFormOptions);
            return false;
        }, {
            validate : function() {
                return true;
            }
        });

        //定制化的Checkbox样式
        $contactForm.find("input").iCheck({
            checkboxClass : "icheckbox_square-blue",
            radioClass : "iradio_square-blue",
            increaseArea : "20%" // optional
        });
    });
</script>
<s:form theme="simple" id="contactForm" name="contact" class="horizontal-form" method='post'>
	<s:hidden name="contactModel.id" />
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
		<h4 class="modal-title">联系人管理</h4>
	</div>
	<div class="modal-body form">
		<div class="form-body">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人姓名：</label>
						<s:textfield class="form-control input-sm" name="contactModel.name" maxlength="100" placeholder="请输入联系人姓名..." required="required" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人性别：</label>
						<div class="radio-list">
							<s:radio list="#{'Male':'男','Female':'女'}" name="contactModel.gender" listKey="key" listValue="value" value="contactModel.gender"></s:radio>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人手机：</label>
						<s:textfield class="form-control input-sm" name="contactModel.mobile" maxlength="15" placeholder="请输入联系人手机..." required="required" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人邮箱：</label>
						<s:textfield type="email" class="form-control input-sm" name="contactModel.email" maxlength="100" placeholder="请输入联系人邮箱..." required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人地址：</label>
						<s:textfield class="form-control input-sm" name="contactModel.address" maxlength="100" placeholder="请输入联系人地址..." required="required" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人职位：</label>
						<s:textfield class="form-control input-sm" name="contactModel.position" maxlength="100" placeholder="请输入联系人地址..." />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">联系人分类：</label>
						<s:select class="form-control input-sm" name="contactModel.category.id" list="contactCategorys" listKey="id" listValue="name">
						</s:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">是否为常用联系人：</label><br>
						<s:checkbox fieldValue="true" name="contactModel.isFrequent"></s:checkbox>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal-footer form-actions">
		<button type="submit" class="btn btn-primary">
			<i class="fa fa-floppy-o"></i> 保存
		</button>
		<button type="button" data-dismiss="modal" class="btn btn-default">
			<i class="fa fa-times"></i> 关闭
		</button>
	</div>
</s:form>