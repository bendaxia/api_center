function listWithApiGroup(){
$.ajax({
		url : WebApplicationPath + "/api/group/list",
		type : "post",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			
		},
		success : function(result) {
			var apiGroup_html = $('apiGroup');
			for (var i = 0; i<result.data.length; i++) {
				apiGroup_html +="<option value='"+result.data[i].id+"'>"+result.data[i].groupName+"</option>";
			}
			$("#apiGroup").html(apiGroup_html);
		}
	});
}
var row_count = 0;
function addParamTable() {
	var tableid = $('#paramTableId');
	var firstTr = tableid.find('tbody>tr:first');
	var row = $("<tr></tr>");

	var td = $("<td></td>");
	td.append($("<input type='checkbox' name='ch1' />"));
	row.append(td);

	var td1 = $("<td></td>");
	td1.append($("<input type='text' class='form-control' />"));
	row.append(td1);

	var td2 = $("<td></td>");
	td2
			.append($("<select class='form-control'><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select>"));
	row.append(td2);

	var td3 = $("<td><input name='Fruit" + row_count
			+ "'  type='radio' value='0' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit" + row_count
			+ "' type='radio' value='1' />否</td>");
	td3.append($(""));
	row.append(td3);

	var td4 = $("<td></td>");
	td4.append($("<input type='text' class='form-control' />"));
	row.append(td4);

	var td5 = $("<td></td>");
	td5.append($("<input type=’text‘ class='form-control' />"));
	row.append(td5);

	tableid.append(row);
	row_count++;
}
function delParamTable() {
	$("input[name='ch1']:checked").each(function() {
		n = $(this).parents("tr").index();
		$("table#paramTableId").find("tr:eq(" + n + ")").remove();
	});
}

function addReturnTable() {
	var tableid2 = $('#returnTableId');
	var firstTr = tableid2.find('tbody>tr:first');
	var row = $("<tr></tr>");

	var td = $("<td></td>");
	td.append($("<input type='checkbox' name='ch'  />"));
	row.append(td);

	var td1 = $("<td></td>");
	td1.append($("<input type='text' class='form-control' />"));
	row.append(td1);

	var td2 = $("<td></td>");
	td2
			.append($("<select class='form-control'><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select>"));
	row.append(td2);

	var td3 = $("<td><input name='Fruit2" + row_count
			+ "' type='radio' value='0' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit2" + row_count
			+ "' type='radio' value='1' />否</td>");
	td3.append($(""));
	row.append(td3);

	var td4 = $("<td></td>");
	td4.append($("<input type='text' class='form-control' />"));
	row.append(td4);

	var td5 = $("<td></td>");
	td5.append($("<input type=’text‘ class='form-control' />"));
	row.append(td5);

	tableid2.append(row);
	row_count++;
}
function delReturnTable() {
	$("input[name='ch']:checked").each(function() {
		n = $(this).parents("tr").index();
		$("table#returnTableId").find("tr:eq(" + n + ")").remove();
	});
}
function addApi(){
	var apiName = $("#inputEmail3").val();
	var apiGroupId = $("#apiGroup").val();
	var apiAgreement = $("#apiAgreement").val();
	var apiMode = $("#apiMode").val();
	var apiDomain = $("#domain").val();
	var apiAddress = $("#address").val();
	var apiDescription = $("#description").val();

	// 取第一个table
	var tableid = $('#paramTableId');
	// 从table拿到tr
	var tr = tableid.find('tr:gt(0)');// :gt(0)

	// 取第二个table
	var tableid2 = $('#returnTableId');
	// 从table拿到tr
	var tr2 = tableid2.find('tr:gt(0)');

	var apiParams = [];
	tr.each(function(i, e) {
		var apiParam = {};
		// 从tr拿到td
		var td = $(this).find("td");
		// 从td取值
		apiParam.paramName = td.eq(1).find("input").val();
		apiParam.paramType = td.eq(2).find("select").val();
		apiParam.isoptional = td.eq(3).find("input:checked").val();
		apiParam.testValue = td.eq(4).find("input").val();
		apiParam.paramDescribe = td.eq(5).find("input").val();
		apiParams.push(apiParam);
		// apiParams.push(JSON.stringify(apiParam));
	});
	var apiReturns = [];
	tr2.each(function(i, e) {
		var apiReturn = {};
		// 从tr拿到td
		var td2 = $(this).find("td");
		// 从td取值
		apiReturn.returnName = td2.eq(1).find("input").val();
		apiReturn.returnType = td2.eq(2).find("select").val();
		// otr.r_areoptional = td2.eq(3).find("input:checked").val();
		// otr.r_defaults = td2.eq(4).find("input").val();
		apiReturn.returnDescribe = td2.eq(5).find("input").val();
		apiReturns.push(apiReturn);
		// apiReturns.push(JSON.stringify(apiReturn));

	});
		console.log(apiReturns);
	console.log(apiParams);
	if (apiGroupId == 0) {
		alert("请选择接口类型");
		return;
	}
	if (apiName == "" || apiAgreement == "" || apiMode == ""
			|| apiDomain == "" || apiAddress == "" || apiDescription=="") {
		alert("请将信息填写完整")
		return;
	}
	if(apiParams.length==0){
		alert("不要企图不填参数!");
	}
	for (i = 0; i < apiParams.length; i++) {
		var param = apiParams[i];
		// var paramJson = JSON.parse(param);
		// if (paramJson.paramName == "") {
		// 	alert("请填写参数名称");
		// 	return;
		// }
		// if (paramJson.testValue == "") {
		// 	alert("请填写默认值");
		// 	return;
		// }

		if (param.paramName == "") {
			alert("请填写参数名称");
			return;
		}
		if (param.testValue == "") {
			alert("请填写默认值");
			return;
		}
	}
	$.ajax({
		url : WebApplicationPath + "/api/add",
		type : "post",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		beforeSend : function(xhr){
			xhr.setRequestHeader("x-request-user-id","1");//临时这么写
		},
		data : {
			apiName:apiName,
			apiGruopId:apiGroupId,
			apiAgreement:apiAgreement,
			apiMode:apiMode,
			apiDomain:apiDomain,
			apiAddress:apiAddress,
			apiDescribe:apiDescription,
			apiParams:apiParams,
			apiReturns:apiReturns
		},
		success : function(result) {
			
		}
	});
}














