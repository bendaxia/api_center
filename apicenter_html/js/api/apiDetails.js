function listWithGroup() {
	$.ajax({
				url : WebApplicationPath + "/api/group/list/catalog",
				type : "post",
				dataType : "json",
				success : function(result) {
					var interface_html = "";
					var option_html = "";
					if (result.code != 200) {
						alert(result.message);
						$("#interfaceType_id").html(option_html);
						$("#interfaceTypeId").html(interface_html);
						return;
					}
					for (var i = 0; i < result.data.length; i++) {
						var infa = result.data[i];
						interface_html += ('<ul  class="nav nav-pills nav-stacked">'+ '<li role="presentation" class="group"><a href="javascript:void(0)"><i class="glyphicon glyphicon-equalizer"></i>'+ infa.gruopName + '</a>' + '<ul  class="nav nav-pills nav-stacked" >');
						option_html += ('<option value="0">'+ infa.gruopName + '</option>');
						for (var y = 0; y < infa.apiGroupDetails.length; y++) {
							var ins = infa.apiGroupDetails[y];
							interface_html += ('<li role="presentation">'+ '<a href="/apicenter_html/html/api/apiDetails.html?apiId='+ ins.apiId + '">' + ins.apiName + '</a>' + '</li>');
						}
						interface_html += ('</ul>' + '</li>' + '</ul>');
					}
					$("#interfaceTypeId").html(interface_html);
					initLeft();// 菜单效果
				}
			});
}
//菜单效果
function initLeft(){
	$(".nav-pills>li.group>a").click(function(){
		var pt = $(this).parent().toggleClass("click");
		if(pt.hasClass("click")){
			pt.children("ul").children().slideUp("fast");
		}else{
			pt.children("ul").children().slideDown("fast");
		}
		return false;
	});
}
/**
 * 获取api
 * @returns
 */
function getApi(){
	var apiId = getUrlParam('apiId');
	$.ajax({
		url : WebApplicationPath + "/api/api",
		type : "post",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			apiId:apiId
		},
		success : function(result) {
			if(result.code!=Response_Code_OK){
				alert(result.message);
				return;
			}
			var apiData = result.data;

			$("#nameId").html(apiData.apiName);
			$("#agreementId").html(apiData.apiAgreement);
			$("#mannerId").html(apiData.apiMode);
			$("#domainId").html(apiData.apiDomain);
			$("#addressId").html(apiData.apiAddress);
			$("#descriptionId").html(apiData.apiDescribe);
			$("#picId").html(apiData.userName);
			$("#picphoneId").html("暂时不支持");
			var param_html = "";
			var return_html = "";
			param_html += ('<tr>' + '<th width="15%">名称</th>'
					+ '<th width="15%">类型</th>'
					+ '<th width="15%">是否可选</th>'
					+ '<th width="15%">默认值</th>'
					+ '<th width="30%">描述</th>' + '</tr>');
			return_html += ('<tr>' + '<th width="15%">名称</th>'
					+ '<th width="15%">类型</th>'
					+ '<th width="15%">是否可选</th>'
					+ '<th width="15%">默认值</th>'
					+ '<th width="30%">描述</th>' + '</tr>');

			for (i = 0; i < apiData.params.length; i++) {
				var p = apiData.params[i];
				param_html += ('<tr>' + '<td>' + p.paramName + '</td>'
						+ '<td>' + p.paramType + '</td>');
				if (p.isoptional == 0) {
					param_html += ('<td>是</td>');
				} else if (p.isoptional == 1) {
					param_html += ('<td>否</td>');
				}
				param_html += (
				// '<td>'+p.defaults+'</td>'+
				'<td><input id="hehe" type="text" style="width:80px;" value=' + p.testValue
						+ ' /></td>' + '<td>' + p.paramDescribe + '</td>' + '</tr>');
			}
			for (i = 0; i < apiData.returns.length; i++) {
				var r = apiData.returns[i];
				return_html += ('<tr>' + '<td>' + r.returnName + '</td>'
						+ '<td>' + r.returnType + '</td>');
				// if (r.areoptional == 0) {
					return_html += ('<td>是</td>');
				// } else if (r.areoptional == 1) {
				// 	return_html += ('<td>否</td>');
				// }
				// return_html += ('<td>' + + '</td>' + '<td>'
				return_html += ('<td></td>' + '<td>'
						 + r.returnDescribe + '</td>' + '</tr>');

			}
			$("#rid").html(return_html);
			$("#pid").html(param_html);
		}
	});
}

/**
 * 修改
 * @returns
 */
function update(){
	var id = getUrlParam('apiId');
	window.location = "apiUpdate.html?apiId=" + id;
}