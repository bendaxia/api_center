if(!$.browser){
	$.browser = {};
	$.browser.mozilla = /firefox/.test(navigator.userAgent.toLowerCase());
	$.browser.webkit = /webkit/.test(navigator.userAgent.toLowerCase());
	$.browser.opera = /opera/.test(navigator.userAgent.toLowerCase());
	$.browser.msie = /msie/.test(navigator.userAgent.toLowerCase());
}
function $get(key){
	var v = location.search.substring(1);
	var arr1 = v.split("&");
	for(var i=0;i<arr1.length;i++){
		var arr2 = arr1[i].split("=");
		if(arr2[0]==key){
			return arr2[1];
		}
	}
}
$.fn.disabled = function(){
	$(this).addClass("disabled").attr("disabled",true);
}
$.fn.enabled = function(){
	$(this).removeClass("disabled").removeAttr("disabled");
}
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
$(function(){
	$(".nav-pills>li.group>a").click(function(){
		var pt = $(this).parent().toggleClass("click");
		if(pt.hasClass("click")){
			pt.children("ul").children().slideUp("fast");
		}else{
			pt.children("ul").children().slideDown("fast");
		}
		return false;
	});
});

//验证码倒计时
function funcYzmTime(me){		
	$(me).disabled();
	var i = 60;
	var tag = me.tagName.toLowerCase() == "button"?"innerHTML":"value";
	me[tag] = "验证码(60)";
	setInterval(function(){
		i--;
		if(i<0){
			$(me).enabled();
			me[tag] = "获取验证码";
			return;
		}
		me[tag] = "验证码("+i+")";
	},1000);
}
//绑定新增衣物信息事件
function bindAddInfo(selector,str,callback){
	$(selector).change(function(){
		if($.trim(this.value)==""){
			return;
		}		
		if(selector=='#txtAddName'){
			var arr = this.value.split("/");
			if(arr.length!=2){
				$.loadInfo("正确格式应该为：名称/价格");
				return;
			}else if(isNaN(arr[1])){
				$.loadInfo("价格必须为数字");
				return;
			}
			$(this).before(str.replace("{content}",arr[0]).replace("{price}",arr[1]));
		}else{
			$(this).before(str.replace("{content}",this.value));
		}
		
		this.value = "";
	}).keyup(function(e){
		if(e.keyCode==13){
			$(this).change();
		}
	})
}