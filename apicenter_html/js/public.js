var   WebApplicationPath = "http://127.0.0.1:8080/apicenter";//全局域名
var  Response_Code_OK  =  200;//与客户端约定的code值
/**
 * url取参数
 * 
 * @param name
 * @returns
 */
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}