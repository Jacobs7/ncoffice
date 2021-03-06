﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>应用源</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="datax:applySource:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增源</a></shiro:hasPermission>
		<shiro:hasPermission name="datax:applySource:update"><a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑源</a></shiro:hasPermission>
		<shiro:hasPermission name="datax:applySource:delete"><a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除源</a></shiro:hasPermission>
		<shiro:hasPermission name="datax:applySource:connect"><a class="waves-effect waves-button" href="javascript:;" onclick="connnectAction()"><i class="zmdi zmdi-close"></i> 连接源</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script>
	var $table = $('#table');
	$(function() {
		// bootstrap table初始化
		$table.bootstrapTable({
			url: '${basePath}/manage/applySource/list',
			height: getHeight(),
			striped: true,
			search: true,
			showRefresh: true,
			showColumns: true,
			minimumCountColumns: 2,
			clickToSelect: true,
			detailView: true,
			detailFormatter: 'detailFormatter',
			pagination: true,
			paginationLoop: false,
			sidePagination: 'server',
			silentSort: false,
			smartDisplay: false,
			escape: true,
			searchOnEnterKey: true,
			idField: 'id',
			maintainSelected: true,
			toolbar: '#toolbar',
			columns: [
				{field: 'ck', checkbox: true},
				{field: 'id', title: '编号', sortable: true,align: 'center'},
				{field: 'linkIp', title: '连接', sortable:true,align: 'center'},
				{field: 'dbUser', title: '用户', sortable:true,align: 'center'},
				{field: 'dbPwd', title: '密码', sortable:true,align: 'center'},
				{field: 'dbPort', title: '端口', sortable:true,align: 'center'},
				{field: 'typeId', title: '类型', sortable:true,align: 'center'},
				{field: 'taskId', title: '应用任务', sortable:true,align: 'center'},
				{field: 'parentId', title: '数据来源', sortable:true,align: 'center'},
				{field: 'status', title: '状态', sortable: true,align:'center'},

				{field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
			]
		});
	});
	// 格式化操作按钮
	function actionFormatter(value, row, index) {
		return [
			'<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
			'<a class="connect" href="javascript:;" onclick="connnectAction()" data-toggle="tooltip" title="Connect"><i class="glyphicon glyphicon-play"></i></a>'
		].join('');
	}
	// 格式化图标
	function iconFormatter(value, row, index) {
		return '<i class="' + value + '"></i>';
	}
	// 格式化类型
	function typeFormatter(value, row, index) {
		if (value == 1) {
			return '<span class="label label-primary">OK</span>';
		}
		if (value == 0) {
			return '<span class="label label-danger">Fail</span>';
		}
	}

	var connectDialog;
	function connnectAction() {

		var rows = $table.bootstrapTable('getSelections');


		$.ajax({
			type:'get',
			url: '${basePath}/manage/applySource/connect/'+rows[0].id,
			success:function(result){

				$.confirm({
					theme: 'dark',
					animation: 'rotateX',
					closeAnimation: 'rotateX',
					title: false,
					content: result.data,
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

	// 新增
	var createDialog;
	function createAction() {
		createDialog = $.dialog({
			animationSpeed: 300,
			title: '新增应用源',
			content: 'url:${basePath}/manage/applySource/create',
			onContentReady: function () {
				initMaterialInput();
			}
		});
	}
	// 编辑
	var updateDialog;
	function updateAction() {
		var rows = $table.bootstrapTable('getSelections');

		if (rows.length != 1) {
			$.confirm({
				title: false,
				content: '请选择一条记录！',
				autoClose: 'cancel|3000',
				backgroundDismiss: true,
				buttons: {
					cancel: {
						text: '取消',
						btnClass: 'waves-effect waves-button'
					}
				}
			});
		} else {
			updateDialog = $.dialog({
				animationSpeed: 300,
				title: '编辑应用源',
				content: 'url:${basePath}/manage/applySource/update/' + rows[0].id,
				onContentReady: function () {
					initMaterialInput();
				}
			});
		}
	}
	// 删除
	var deleteDialog;
	function deleteAction() {
		var rows = $table.bootstrapTable('getSelections');
		if (rows.length == 0) {
			$.confirm({
				title: false,
				content: '请至少选择一条记录！',
				autoClose: 'cancel|3000',
				backgroundDismiss: true,
				buttons: {
					cancel: {
						text: '取消',
						btnClass: 'waves-effect waves-button'
					}
				}
			});
		} else {
			deleteDialog = $.confirm({
				type: 'red',
				animationSpeed: 300,
				title: false,
				content: '确认删除该类目吗？${basePath}',
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'waves-effect waves-button',
						action: function () {
							var ids = new Array();
							for (var i in rows) {
								ids.push(rows[i].id);
							}
							$.ajax({
								type: 'get',
								url: '${basePath}/manage/applySource/delete/' + ids.join("-"),
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
										deleteDialog.close();
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
					},
					cancel: {
						text: '取消',
						btnClass: 'waves-effect waves-button'
					}
				}
			});
		}
	}
</script>
</body>
</html>