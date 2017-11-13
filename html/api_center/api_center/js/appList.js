var page = 1;// page全局变量
function queryAppManagement() { 
	$
			.ajax({
				url : WebApplicationPath + "/app/queryApp.html",
				type : "post",
				dataType : "json",
				data : {
					page : 1,
					pagesize : 10
				},
				success : function(result) {
					var td_html = "";
					td_html += ("<tr>" + '<th></th>' + '<th>名称</th>'
							+ '<th>渠道</th>' + '<th>负责人</th>' + '<th>联系方式</th>'
							+ '<th>AppId</th>' + '<th>AppSecret</th>'
							+ '<th>状态</th>' + '</tr>');
					if (result.code != "20200") {
						$("#tableid").html(td_html);
						return;
					}
					if (result.result.length == 0) {
						$("#pageid").html("1");
						$("#tableid").html(td_html);
						return;
					}
					for (i = 0; i < result.result.length; i++) {
						var app = result.result[i];
						td_html += ('<tr>'
								+ '<td><input type="checkbox" name = "cbn" value="'
								+ app.id + '" /></td>' + '<td>' + app.name
								+ '</td>' + '<td>' + app.channel + '</td>'
								+ '<td>' + app.pic + '</td>' + '<td>'
								+ app.phone + '</td>' + '<td>' + app.appId
								+ '</td>' + '<td>' + app.appsecret + '</td>');
						if (app.status == 0) {
							td_html += ('<td>已开启</td>' + '</tr>');
						} else {
							td_html += ('<td>已关闭</td>' + '</tr>');
						}
					}
					page = 1;// 全局变量清1
					$("#pageid").html(page);
					$("#tableid").html(td_html);
				}
			});
}
// 下一页
function queryAppManagement_Next() {
	page++;
	$
			.ajax({
				url : WebApplicationPath + "/app/queryApp.html",
				type : "post",
				dataType : "json",
				data : {
					page : page,
					pagesize : 10
				},
				success : function(result) {
					var td_html = "";
					td_html += ("<tr>" + '<th></th>' + '<th>名称</th>'
							+ '<th>渠道</th>' + '<th>负责人</th>' + '<th>联系方式</th>'
							+ '<th>AppId</th>' + '<th>AppSecret</th>'
							+ '<th>状态</th>' + '</tr>');
					if (result.result.length == 0) {
						page--;
						alert("当前为最后一页")
						return;
					}
					if (result.code != "20200") {
						$("#tableid").html(td_html);
						return;
					}
					if (result.result.length == 0) {
						$("#pageid").html("1");
						$("#tableid").html(td_html);
						return;
					}
					for (i = 0; i < result.result.length; i++) {
						var app = result.result[i];
						td_html += ('<tr>'
								+ '<td><input type="checkbox" name = "cbn" value="'
								+ app.id + '" /></td>' + '<td>' + app.name
								+ '</td>' + '<td>' + app.channel + '</td>'
								+ '<td>' + app.pic + '</td>' + '<td>'
								+ app.phone + '</td>' + '<td>' + app.appId
								+ '</td>' + '<td>' + app.appsecret + '</td>');
						if (app.status == 0) {
							td_html += ('<td>已开启</td>' + '</tr>');
						} else {
							td_html += ('<td>已关闭</td>' + '</tr>');
						}
					}
					$("#pageid").html(page);
					$("#tableid").html(td_html);
				}
			});
}

// 上一页
function queryAppManagement_Previous() {
	if (page != 1) {
		page--;
	} else {
		alert("当前为第一页");
		return;
	}
	$
			.ajax({
				url : WebApplicationPath + "/app/queryApp.html",
				type : "post",
				dataType : "json",
				data : {
					page : page,
					pagesize : 10
				},
				success : function(result) {
					var td_html = "";
					td_html += ("<tr>" + '<th></th>' + '<th>名称</th>'
							+ '<th>渠道</th>' + '<th>负责人</th>' + '<th>联系方式</th>'
							+ '<th>AppId</th>' + '<th>AppSecret</th>'
							+ '<th>状态</th>' + '</tr>');
					if (result.code != "20200") {
						$("#tableid").html(td_html);
						return;
					}
					if (result.result.length == 0) {
						$("#pageid").html("1");
						$("#tableid").html(td_html);
						return;
					}
					for (i = 0; i < result.result.length; i++) {
						var app = result.result[i];
						td_html += ('<tr>'
								+ '<td><input type="checkbox" name = "cbn" value="'
								+ app.id + '" /></td>' + '<td>' + app.name
								+ '</td>' + '<td>' + app.channel + '</td>'
								+ '<td>' + app.pic + '</td>' + '<td>'
								+ app.phone + '</td>' + '<td>' + app.appId
								+ '</td>' + '<td>' + app.appsecret + '</td>');
						if (app.status == 0) {
							td_html += ('<td>已开启</td>' + '</tr>');
						} else {
							td_html += ('<td>已关闭</td>' + '</tr>');
						}
					}
					$("#pageid").html(page);
					$("#tableid").html(td_html);
				}
			});
}

function updateAppManagement(type) {
	var obj = [];
	var r = document.getElementsByName("cbn");
	for (var i = 0; i < r.length; i++) {
		var otr = {};
		if (r[i].checked) {
			otr.id = r[i].value;
			otr.type = type;
			obj.push(otr);
		}
	}
	if (obj.length == 0) {
		alert("请选择")
		return;
	}
	var jsonData = JSON.stringify(obj);
	$.ajax({
		url : WebApplicationPath + "/app/updateApp.html",
		type : "post",
		dataType : "json",
		data : {
			data : jsonData
		},
		success : function(result) {
			if (result.code == "20200") {
				alert("操作成功");
				queryAppManagement();
				return;
			}
			alert("操作失败");
		}
	});
}
