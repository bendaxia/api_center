/**
 * Json美化
 * 
 * @param s
 * @param count
 * @returns
 */
function repeat(s, count) {
	return new Array(count + 1).join(s);
}

function formatJson(json) {

	var json = json;

	var i = 0, len = 0, tab = "    ", targetJson = "", indentLevel = 0, inString = false, currentChar = null;

	for (i = 0, len = json.length; i < len; i += 1) {
		currentChar = json.charAt(i);

		switch (currentChar) {
		case '{':
		case '[':
			if (!inString) {
				targetJson += currentChar + "\n" + repeat(tab, indentLevel + 1);
				indentLevel += 1;
			} else {
				targetJson += currentChar;
			}
			break;
		case '}':
		case ']':
			if (!inString) {
				indentLevel -= 1;
				targetJson += "\n" + repeat(tab, indentLevel) + currentChar;
			} else {
				targetJson += currentChar;
			}
			break;
		case ',':
			if (!inString) {
				targetJson += ",\n" + repeat(tab, indentLevel);
			} else {
				targetJson += currentChar;
			}
			break;
		case ':':
			if (!inString) {
				targetJson += ": ";
			} else {
				targetJson += currentChar;
			}
			break;
		case ' ':
		case "\n":
		case "\t":
			if (inString) {
				targetJson += currentChar;
			}
			break;
		case '"':
			if (i > 0 && json.charAt(i - 1) !== '\\') {
				inString = !inString;
			}
			targetJson += currentChar;
			break;
		default:
			targetJson += currentChar;
			break;
		}
	}
	return targetJson;
}

function queryInterface() {
	var id = getUrlParam('id');
	$
			.ajax({
				url : WebApplicationPath + "/interface/queryInterFace.html",
				type : "post",
				dataType : "json",
				data : {
					id : id
				},
				success : function(result) {
					result = eval(result);
					if (result.code != '20200') {
						alert(result.message);
						return;
					}
					var interfaces = result.result[0];
					$("#nameId").html(interfaces.name);
					$("#agreementId").html(interfaces.agreement);
					$("#mannerId").html(interfaces.manner);
					$("#domainId").html(interfaces.domain);
					$("#addressId").html(interfaces.address);
					$("#descriptionId").html(interfaces.description);
					$("#picId").html(interfaces.pic);
					$("#picphoneId").html(interfaces.picphone);
					var pid_html = "";
					var rid_html = "";
					pid_html += ('<tr>' + '<th width="15%">名称</th>'
							+ '<th width="15%">类型</th>'
							+ '<th width="15%">是否可选</th>'
							+ '<th width="15%">默认值</th>'
							+ '<th width="30%">描述</th>' + '</tr>');
					rid_html += ('<tr>' + '<th width="15%">名称</th>'
							+ '<th width="15%">类型</th>'
							+ '<th width="15%">是否可选</th>'
							+ '<th width="15%">默认值</th>'
							+ '<th width="30%">描述</th>' + '</tr>');

					for (i = 0; i < interfaces.interfaceParameters.length; i++) {
						var p = interfaces.interfaceParameters[i];
						pid_html += ('<tr>' + '<td>' + p.name + '</td>'
								+ '<td>' + p.type + '</td>');
						if (p.areoptional == 0) {
							pid_html += ('<td>是</td>');
						} else if (p.areoptional == 1) {
							pid_html += ('<td>否</td>');
						}
						pid_html += (
						// '<td>'+p.defaults+'</td>'+
						'<td><input id="hehe" type="text" value=' + p.defaults
								+ ' /></td>' + '<td>' + p.description + '</td>' + '</tr>');
					}

					for (i = 0; i < interfaces.interfaceReturnParameters.length; i++) {
						var r = interfaces.interfaceReturnParameters[i];
						rid_html += ('<tr>' + '<td>' + r.name + '</td>'
								+ '<td>' + r.type + '</td>');
						if (r.areoptional == 0) {
							rid_html += ('<td>是</td>');
						} else if (r.areoptional == 1) {
							rid_html += ('<td>否</td>');
						}
						rid_html += ('<td>' + r.defaults + '</td>' + '<td>'
								+ r.description + '</td>' + '</tr>');
					}
					$("#rid").html(rid_html);
					$("#pid").html(pid_html);
				}
			});
}
// 接口模拟
function send() {
	var otr = {};
	otr.manner = document.getElementById("mannerId").innerHTML;
	otr.domain = document.getElementById("domainId").innerHTML;
	otr.address = document.getElementById("addressId").innerHTML;
	otr.milieu = $("#milieu").val();
	// 取第一个table
	var tableid = $('#pid');
	// 从table拿到tr
	var tr = tableid.find('tr:gt(0)');

	if (tr.html() != null && tr.html() != "") {
		var P_obj = [];
		tr.each(function(i, e) {
			var otr = {};
			// 从tr拿到td
			var td = $(this).find("td");
			// 从td取值
			otr.p_name = td.eq(0).html();
			otr.p_defaults = td.eq(3).find("input").val();
			// otr.p_defaults = td.eq(3).html();
			P_obj.push(otr);
		});
		otr.p_obj = P_obj;
	}
	var jsonData = JSON.stringify(otr);
	$.ajax({
		url : WebApplicationPath + "/api/send.html",
		type : "post",
		dataType : "json",
		// contentType : "application/json;charset=utf-8",
		data : {
			data : jsonData
		},
		success : function(result) {
			var a = result.result.result;
			var c = document.createElement('div');
			c.innerHTML = a;
			a = c.innerText || c.textContent;
			c = null;
			a = jQuery.parseJSON(a);
			json = JSON.stringify(a);
			json = formatJson(json);

			var header = JSON.stringify(result.result.header) 
			header = formatJson(header);
			
			$("#jsonId").html(json);
			$("#proId").html(header);
			$("#yuanId").html(result.result.result);
		}
	});
}
// ab性能测试
function abSend() {
	var otr = {};
	otr.address = document.getElementById("addressId").innerHTML;
	otr.domain = document.getElementById("domainId").innerHTML;
	otr.address = document.getElementById("addressId").innerHTML;
	otr.milieu = $("#milieu").val();
	otr.cNum = $("#cNumId").val();
	otr.nNum = $("#nNumId").val();
	if (isNaN(otr.cNum)) {
		alert("胡闹,你家阿拉伯数字这么写");
		return;
	}
	if (isNaN(otr.nNum)) {
		alert("胡闹,你家阿拉伯数字这么写");
		return;
	}
	// 取第一个table
	var tableid = $('#pid');
	// 从table拿到tr
	var tr = tableid.find('tr:gt(0)');

	if (tr.html() != null && tr.html() != "") {
		var P_obj = [];
		tr.each(function(i, e) {
			var otr = {};
			// 从tr拿到td
			var td = $(this).find("td");
			// 从td取值
			otr.p_name = td.eq(0).html();
			otr.p_defaults = td.eq(3).find("input").val();
			P_obj.push(otr);
		});
		otr.p_obj = P_obj;
	}
	var dataJson = JSON.stringify(otr);
	$.ajax({
		url : WebApplicationPath + "/api/perform.html",
		type : "post",
		// dataType : "json",
		// contentType : "application/json;charset=utf-8",
		data : {
			data : dataJson
		},
		success : function(result) {
			$("#abSendId").html(result);
		}
	});
}

function update() {
	var id = getUrlParam('id');
	window.location = "/interface/interFaceUpdate.html?id=" + id;
}
