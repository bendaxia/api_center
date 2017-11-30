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
function isJSON(str) {
	if(str==""){
		return false;
	}
    if (typeof str == 'string') {
        try {
            var obj=JSON.parse(str);
            if(str.indexOf('{')>-1){
                return true;
            }else{
                return false;
            }

        } catch(e) {
            console.log(e);
            return false;
        }
    }
    return false;
}
function IsURL(str_url){
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
    + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
    + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
    + "|" // 允许IP和DOMAIN（域名）
    + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
    + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
    + "[a-z]{2,6})" // first level domain- .com or .museum
    + "(:[0-9]{1,4})?" // 端口- :80
    + "((/?)|" // a slash isn't required if there is no file name
    + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re=new RegExp(strRegex);
    //re.test()
    if (re.test(str_url)){
        return (true);
    }else{
        return (false);
    }
}