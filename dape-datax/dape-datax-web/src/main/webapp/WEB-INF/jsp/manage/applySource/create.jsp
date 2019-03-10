<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="dataSourceType" class="crudDialog">
	<form id="createForm" method="post">
		<div class="form-group">
			<label for="linkIp">IP</label>
			<input id="linkIp" type="text" class="form-control" name="linkIp" maxlength="20" />
		</div>

		<div class="form-group">
			<label for="dbUser">用户</label>
			<input id="dbUser" type="text" class="form-control" name="dbUser" maxlength="5" />
		</div>

		<div class="form-group">
			<label for="dbPwd">密码</label>
			<input id="dbPwd" type="text" class="form-control" name="dbPwd" maxlength="5" />
		</div>

		<div class="form-group">
			<label for="dbPort">端口</label>
			<input id="dbPort" type="text" class="form-control" name="dbPort" maxlength="5" />
		</div>

		<div class="form-group">
			<div class="fg-line">
				<select id="typeId" name="typeId" style="width: 100%">
					<option value="0">源类型</option>
					<c:forEach var="type" items="${dataxSourceType}">
						<option value="${type.id}">${type.driverName}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="taskId">任务</label>
			<input id="taskId" type="text" class="form-control" name="taskId" maxlength="5" />
		</div>


		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/manage/applySource/create',
        data: $('#createForm').serialize(),
        beforeSend: function() {
            if ($('#linkIp').val() == '') {
                $('#linkIp').focus();
                return false;
            }
            if ($('#dbUser').val() == '') {
                $('#dbUser').focus();
                return false;
            }
			if ($('#dbPwd').val() == '') {
				$('#dbPwd').focus();
				return false;
			}
			if ($('#dbPort').val() == '') {
				$('#dbPort').focus();
				return false;
			}
			if ($('#typeId').val() == '') {
				$('#typeId').focus();
				return false;
			}


        },
        success: function(result) {
			if (result.code != 1) {
				if (result.data instanceof Array) {
					$.each(result.data, function(index, value) {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: value.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
					});
				} else {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: result.data.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
				}
			} else {
				createDialog.close();
				$table.bootstrapTable('refresh');
			}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			$.confirm({
				theme: 'dark',
				animation: 'rotateX',
				closeAnimation: 'rotateX',
				title: false,
				content: textStatus,
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'waves-effect waves-button waves-light'
					}
				}
			});
        }
    });
}
</script>