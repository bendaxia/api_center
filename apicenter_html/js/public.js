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