function queryInterfaceType() {
	$
			.ajax({
				url : WebApplicationPath
						+ "/interfacetype/queryInterfaceType.html",
				type : "post",
				dataType : "json",
				success : function(result) {
					
					var interface_html = "";
					var option_html = "";
					interface_html += ('<ul  class="nav nav-pills nav-stacked">'
							+ '<li role="presentation" class="group"><a href="javascript:void(0)"><i class="glyphicon glyphicon-equalizer"></i>App管理</a>'
							+ '<ul  class="nav nav-pills nav-stacked" >'
							+ '<li role="presentation">'
							+ '<a href="/app/appList.html">App列表</a>'
							+ '</li>'
							+ '</ul>' + '</li>' + '</ul>');
					if (result.code != "20200") {
						alert(result.message);
						$("#interfaceType_id").html(option_html);
						$("#interfaceTypeId").html(interface_html);
						return;
					}
					
					for (var i = 0; i < result.result.length; i++) {
						var infa = result.result[i];
						interface_html += ('<ul  class="nav nav-pills nav-stacked">'+ '<li role="presentation" class="group"><a href="javascript:void(0)"><i class="glyphicon glyphicon-equalizer"></i>'+ infa.name + '</a>' + '<ul  class="nav nav-pills nav-stacked" >');
						option_html += ('<option value=' + infa.id + '>'+ infa.name + '</option>');
						for (var y = 0; y < infa.interfaces.length; y++) {
							var ins = infa.interfaces[y];
							interface_html += ('<li role="presentation">'+ '<a href="/interface/interFaceJkxq.html?id='+ ins.id + '">' + ins.name + '</a>' + '</li>');
						}
						interface_html += ('</ul>' + '</li>' + '</ul>');
					}
					
					$("#interfaceTypeId").html(interface_html);
					$("#interfaceType_id").html(option_html);
					initLeft();// 菜单效果
					queryPicUser();//查询联系人
				}
			});
}

function queryPicUser(){
	$.ajax({
		url : WebApplicationPath
				+ "/picuser/queryPicUser.html",
		type : "post",
		dataType : "json",
		success : function(result) {
			var pic_html = "";
			var picphone_html = "";
			if (result.code != "20200") {
				alert(result.message);
				pic_html += ('<option value="0">无联系人</option>');
				$("#pic").html(pic_html);
				return;
			}
			for (var i = 0; i < result.result.length; i++) {
				var picuser = result.result[i];
				pic_html+=(
						'<option value=' + picuser.picphone + '>'+ picuser.picname + '</option>'
				);
			}
			$("#picphone").val(result.result[0].picphone);
			$("#pic").html(pic_html);
		}
	});
}
//下拉框取手机号码
$(function(){
    $("#pic").change(function(){
    	$("#picphone").val($(this).val());
    });
});
var row_count = 0;
function addNewTable1() {
	var tableid = $('#tableid');
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
function delTable1() {
	$("input[name='ch1']:checked").each(function() {
		n = $(this).parents("tr").index();
		$("table#tableid").find("tr:eq(" + n + ")").remove();
	});
}

function addNewTable2() {
	var tableid2 = $('#tableid2');
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
function delTable2() {
	$("input[name='ch']:checked").each(function() {
		n = $(this).parents("tr").index();
		$("table#tableid2").find("tr:eq(" + n + ")").remove();
	});
}

function refer() {
	// 取第一个table
	var tableid = $('#tableid');
	// 从table拿到tr
	var tr = tableid.find('tr:gt(0)');// :gt(0)

	// 取第二个table
	var tableid2 = $('#tableid2');
	// 从table拿到tr
	var tr2 = tableid2.find('tr:gt(0)');

	var P_obj = [];
	tr.each(function(i, e) {
		var otr = {};
		// 从tr拿到td
		var td = $(this).find("td");
		// 从td取值
		otr.p_name = td.eq(1).find("input").val();
		otr.p_type = td.eq(2).find("select").val();
		otr.p_areoptional = td.eq(3).find("input:checked").val();
		otr.p_defaults = td.eq(4).find("input").val();
		otr.p_description = td.eq(5).find("input").val();
		P_obj.push(otr);
	});
	var R_obj = [];
	tr2.each(function(i, e) {
		var otr = {};
		// 从tr拿到td
		var td2 = $(this).find("td");
		// 从td取值
		otr.r_name = td2.eq(1).find("input").val();
		otr.r_type = td2.eq(2).find("select").val();
		otr.r_areoptional = td2.eq(3).find("input:checked").val();
		otr.r_defaults = td2.eq(4).find("input").val();
		otr.r_description = td2.eq(5).find("input").val();
		R_obj.push(otr);
	});
	var otr = {};
	otr.name = $("#inputEmail3").val();
	otr.interfaceType_id = $("#interfaceType_id").val();
	otr.agreement = $("#agreement").val();
	otr.manner = $("#manner").val();
	otr.domain = $("#domain").val();
	otr.address = $("#address").val();
	otr.description = $("#description").val();
	otr.pic = $("#pic").find("option:selected").text();
	otr.picphone = $("#picphone").val();
	otr.r_obj = R_obj;
	otr.p_obj = P_obj;
	if (otr.interfaceType_id == 0) {
		alert("请选择接口类型");
		return;
	}
	if (otr.name == "" || otr.address == "" || otr.description == ""
			|| otr.pic == "" || otr.picphone == "") {
		alert("请将信息填写完整")
		return;
	}
	for (i = 0; i < otr.p_obj.length; i++) {
		var p = otr.p_obj[i];
		if (p.p_name == "") {
			alert("请填写参数名称");
			return;
		}
		if (p.p_defaults == "") {
			alert("请填写默认值");
			return;
		}
	}
	var jsonData = JSON.stringify(otr);
	$.ajax({
		url : WebApplicationPath + "/interface/saveInterFace.html",
		type : "post",
		dataType : "json",
		// contentType : "application/json;charset=utf-8",
		data : {
			data : jsonData
		},
		success : function(result) {
			if (result.code == '20200') {
				alert("提交成功");
				window.location.href = window.location.href;
				return;
			}
			alert("提交失败");
		}
	});
}