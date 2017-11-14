function login(){
	var userNumber = $("#userNumber").val();
	var passWord = $("#passWord").val();
	if(userNumber==""){
		alert("请填写账号");
		return;
	}
	if(passWord==""){
		alert("请填写密码");
		return;
	}
	 //ajax请求
 	$.ajax({
		type : "post",
		url : WebApplicationPath+"/login/login",
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json",
		data : {
			userNumber:userNumber,
			passWord:passWord
		},
		success : function(data) {
			alert(data.message);
			if(data.code==200){
				window.location.href="/apicenter_html/html/api/apiIndex.html"; 
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("请求失败:这真是个悲伤的故事。");
		}
	});   
}