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
						interface_html += ('<ul  class="nav nav-pills nav-stacked" >'+ '<li role="presentation" class="group click"><a href="javascript:void(0)"><i class="glyphicon glyphicon-equalizer"></i>'+ infa.gruopName + '</a>' + '<ul  class="nav nav-pills nav-stacked" >');
						option_html += ('<option value="0">'+ infa.gruopName + '</option>');
						for (var y = 0; y < infa.apiGroupDetails.length; y++) {
							var ins = infa.apiGroupDetails[y];
							interface_html += ('<li role="presentation" style="display: none;">'+ '<a href="/apicenter_html/html/api/apiDetails.html?apiId='+ ins.apiId + '">' + ins.apiName + '</a>' + '</li>');
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