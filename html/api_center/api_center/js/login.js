function login(){
	var loginName = document.getElementById("loginName");
	var loginPwd = document.getElementById("loginPwd");
	$.ajax({
		url : WebApplicationPath+"/user/login.html",
		type : "post",
		dataType : "json",
		data:{ "loginName" : loginName.value,"loginPwd" : loginPwd.value},
		success:function(result){
			if(result.code=="20200"){
				result = eval(result);
				window.location.href="/interface/interFaceIndex.html"; 
			}else{
				alert(result.message);
				return;
			}
		}
	});
}