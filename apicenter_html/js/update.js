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
					//option_html += ('<option value="0">请选择接口类型</option>');
					if (result.code != "20200") {
						alert(result.msg);
						$("#interfaceType_id").html(option_html);
						$("#interfaceTypeId").html(interface_html);
						return;
					}
					for (var i = 0; i < result.result.length; i++) {
						var infa = result.result[i];
						interface_html += ('<ul  class="nav nav-pills nav-stacked">'
								+ '<li role="presentation" class="group"><a href="javascript:void(0)"><i class="glyphicon glyphicon-equalizer"></i>'
								+ infa.name + '</a>' + '<ul  class="nav nav-pills nav-stacked" >');
						option_html += ('<option value=' + infa.id + '>'
								+ infa.name + '</option>');
						for (var y = 0; y < infa.interfaces.length; y++) {
							var ins = infa.interfaces[y];
							interface_html += ('<li role="presentation">'
									+ '<a href="/interface/interFaceJkxq.html?id='
									+ ins.id + '">' + ins.name + '</a>' + '</li>');
						}
						interface_html += ('</ul>' + '</li>' + '</ul>');
					}
					$("#interfaceTypeId").html(interface_html);
					$("#interfaceType_id").html(option_html);
					initLeft();// 菜单效果
					queryInterface();//根据ID查询接口
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
function addNewTable1u() {
	var tableid = $('#tableid');
	var firstTr = tableid.find('tbody>tr:first');
	var row = $("<tr></tr>");

	var td = $("<td></td>");
	td.append($("<input type='checkbox' name='ch1' /><input type='hidden' value='0'>"));
	row.append(td);

	var td1 = $("<td></td>");
	td1.append($("<input type='text' class='form-control' />"));
	row.append(td1);

	var td2 = $("<td></td>");
	td2.append($("<select class='form-control'><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select>"));
	row.append(td2);

	var td3 = $("<td><input name='Fruit"+row_count+"'  type='radio' value='0' />是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit"+row_count+"' type='radio' value='1' />否</td>");
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
var p_hid = "";
function delTable1u() {
	$("input[name='ch1']:checked").each(function() {
		n = $(this).parents("tr").index(); 
		$("table#tableid").find("tr:eq("+n+")").remove();		
		p_hid +=$(this).siblings("input:hidden").val();	
		p_hid+=",";
	});
}

function addNewTable2u() {
	var tableid2 = $('#tableid2');
	var firstTr = tableid2.find('tbody>tr:first');
	var row = $("<tr></tr>");

	var td = $("<td></td>");
	td.append($("<input type='checkbox' name='ch'  /><input type='hidden' value='0'>"));
	row.append(td);

	var td1 = $("<td></td>");
	td1.append($("<input type='text' class='form-control' />"));
	row.append(td1);

	var td2 = $("<td></td>");
	td2.append($("<select class='form-control'><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select>"));
	row.append(td2);

	var td3 = $("<td><input name='Fruit2"+row_count+"' type='radio' value='0' />是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit2"+row_count+"' type='radio' value='1' />否</td>");
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
var r_hid = "";
function delTable2u() {
		$("input[name='ch']:checked").each(function() {
			n = $(this).parents("tr").index(); 
			$("table#tableid2").find("tr:eq("+n+")").remove();
			r_hid +=$(this).siblings("input:hidden").val();	//取出隐藏ID放入全局id中
			r_hid+=",";
		});
}
function queryInterface() {
	var id = getUrlParam('id');
	$.ajax({
		url : WebApplicationPath +  "/interface/queryInterFace.html",
		type : "post",
		dataType : "json",
		data : {
			id:id
		},
		success : function(result) {
			result = eval(result);
			if (result.code != '20200') {
				alert(result.message);
				return;
			}
			var interfaces = result.result[0];
			$("#inputEmail3").val(interfaces.name);
			$("#interfaceType_id").prepend("<option value="+interfaces.arrInterFaceType[0].id+">"+interfaces.arrInterFaceType[0].name+"</option>");//把库中查出来的数据放在option第一个
			$("#interfaceType_id").get(0).selectedIndex = 0;//显示出来
			$("#agreement").val(interfaces.agreement);
			$("#manner").val(interfaces.manner);
			$("#domain").prepend("<option>"+interfaces.domain+"</option>");//把库中查出来的数据放在option第一个
			$("#domain").get(0).selectedIndex = 0;//显示出来
			$("#address").val(interfaces.address);
			$("#description").val(interfaces.description);
			$("#pic").prepend("<option value="+interfaces.picphone+">"+interfaces.pic+"</option>");
			$("#pic").get(0).selectedIndex = 0;//显示出来
			$("#picphone").val(interfaces.picphone);			
//			alert($("#pic").find("option:selected").text());
			var tableid_html ="";
			var tableid2_html ="";
			tableid_html+=(
					'<tr>'	+
					'<th width="5%"></th>'+
					'<th width="15%">名称</th>'+
					'<th width="15%">类型</th>'+
					'<th width="15%">是否可选</th>'+
					'<th width="15%">默认值</th>'+
					'<th width="30%">描述</th>'+
					'</tr>'
			);
			tableid2_html+=(
					'<tr>'	+
					'<th width="5%"></th>'+
					'<th width="15%">名称</th>'+
					'<th width="15%">类型</th>'+
					'<th width="15%">是否可选</th>'+
					'<th width="15%">默认值</th>'+
					'<th width="30%">描述</th>'+
					'</tr>'
			);
			for(i=0;i<interfaces.interfaceParameters.length;i++){
				var p = interfaces.interfaceParameters[i];
				tableid_html+=(
				'<tr>'+
				'<td><input type="checkbox" name="ch1" /><input type="hidden" value='+p.id+'></td>'+
				'<td><input type="text" class="form-control" value='+p.name+' /></td>'+
				'<td><select class="form-control"><option>'+p.type+'</option><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select></td>'
				);
				if(p.areoptional==0){
				tableid_html+=(
				"<td><input name='Fruit"+row_count+"'  type='radio' value='0' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit"+row_count+"' type='radio' value='1' />否</td>"
				);
				}else if(p.areoptional==1){
				tableid_html+=(
				"<td><input name='Fruit"+row_count+"'  type='radio' value='0' />是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit"+row_count+"' type='radio' value='1' checked/>否</td>"
				);	
				}
				tableid_html+=(
				'<td><input type="text" class="form-control" value='+p.defaults+' /></td>'+
				'<td><input type="text" class="form-control" value='+p.description+' /></td>'+
				'</tr>'
				);
				row_count++;
			}
			for(i=0;i<interfaces.interfaceReturnParameters.length;i++){
				var r = interfaces.interfaceReturnParameters[i];
				tableid2_html+=(
				'<tr>'+
				'<td><input type="checkbox" name="ch" /><input type="hidden" value='+r.id+'></td>'+
				'<td><input type="text" class="form-control" value='+r.name+' /></td>'+
				'<td><select class="form-control"><option>'+r.type+'</option><option>整形</option><option>字符串</option><option>浮点</option><option>布尔</option></select></td>'
				);
				if(r.areoptional==0){
				tableid2_html+=(
				"<td><input name='Fruit2"+row_count+"'  type='radio' value='0' checked/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit2"+row_count+"' type='radio' value='1' />否</td>"
				);
				}else if(r.areoptional==1){
				tableid2_html+=(
				"<td><input name='Fruit2"+row_count+"'  type='radio' value='0' />是&nbsp;&nbsp;&nbsp;&nbsp;<input name='Fruit2"+row_count+"' type='radio' value='1' checked/>否</td>"
				);	
				}
				tableid2_html+=(
				'<td><input type="text" class="form-control" value='+r.defaults+' /></td>'+
				'<td><input type="text" class="form-control" value='+r.description+' /></td>'+
				'</tr>'
				);
				row_count++;
			}
			$("#tableid").html(tableid_html);
			$("#tableid2").html(tableid2_html);
		}
	});
}
function updateInterface(){
	//取第一个table
	var tableid = $('#tableid');
	//从table拿到tr
	var tr = tableid.find('tr:gt(0)');//:gt(0)
	
	//取第二个table
	var tableid2 = $('#tableid2');
	//从table拿到tr
	var tr2 = tableid2.find('tr:gt(0)');
	
	var P_obj = [];
	tr.each(function(i,e) {
			var otr = {};			
			//从tr拿到td
			var td = $(this).find("td");
			//从td取值
			otr.p_id = td.eq(0).find("input:hidden").val();
			otr.p_name = td.eq(1).find("input").val();
			otr.p_type = td.eq(2).find("select").val();
			otr.p_areoptional = td.eq(3).find("input:checked").val();
			otr.p_defaults = td.eq(4).find("input").val();
			otr.p_description = td.eq(5).find("input").val();
			P_obj.push(otr);
	});
	var R_obj = [];
	tr2.each(function(i,e) {
		var otr = {};			
		//从tr拿到td
		var td2 = $(this).find("td");
			//从td取值
		otr.r_id = td2.eq(0).find("input:hidden").val();
		otr.r_name = td2.eq(1).find("input").val();
		otr.r_type = td2.eq(2).find("select").val();
		otr.r_areoptional = td2.eq(3).find("input:checked").val();
		otr.r_defaults = td2.eq(4).find("input").val();
		otr.r_description = td2.eq(5).find("input").val();
		R_obj.push(otr);
});
	var otr = {};	
	otr.id = getUrlParam('id');
	otr.name = $("#inputEmail3").val();
	otr.interfaceType_id = $("#interfaceType_id").val();
	otr.agreement = $("#agreement").val();
	otr.manner = $("#manner").val();
	otr.domain = $("#domain").val();
	otr.address = $("#address").val();
	otr.description = $("#description").val();
	otr.pic = $("#pic").find("option:selected").text();
	otr.picphone = $("#picphone").val();
	
	p_hid=p_hid.substring(0,p_hid.length-1);//去掉最后一位的逗号
	r_hid=r_hid.substring(0,r_hid.length-1);//去掉最后一位的逗号
	otr.p_hid = p_hid;
	otr.r_hid = r_hid;
	otr.r_obj = R_obj;
	otr.p_obj = P_obj;
	var op = $("#interfaceType_id").val();
	if(op==0){
		alert("请选择接口类型");
		return;
	}
	var jsonData = JSON.stringify(otr);
	$.ajax({
		url : WebApplicationPath + "/interface/updateInterFace.html",
		type : "post",
		dataType : "json",
		data:{
			data : jsonData
		},
		success:function(result){
			result = eval(result);
			if (result.code == '20200') {
				alert("修改成功");
				window.location.href ='/interface/interFaceJkxq.html?id='+getUrlParam('id');
				return;
			}
			alert("修改失败");
		}
	});
}