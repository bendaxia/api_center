function saveAppManagement() {
	var name = $("#name").val();
	var channel = $("#channel").val();
	var pic = $("#pic").val();
	var phone = $("#phone").val();
	if(name==""||channel==""||pic==""||phone==""){
		alert("填满咯!!!!");
		return;
	}
	$.ajax({
		url : WebApplicationPath + "/app/saveApp.html",
		data : {
			name : name,
			channel : channel,
			pic : pic,
			phone : phone
		},
		type : "post",
		dataType : "json",
		success : function(result) {
			if (result.code=='20200') {
				alert("提交成功");
				$("#phone").val("");
				$("#name").val("");
				$("#channel").val("");
				$("#pic").val("");
				return;
			}
			alert(result.message);
			return;
		}
	});
}