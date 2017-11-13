package com.apicenter.core.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicenter.core.api.common.Response;
import com.apicenter.core.api.consts.BaseController;
import com.apicenter.user.bean.ApiCenterUser;
import com.apicenter.user.service.UserService;

@Controller
@RequestMapping("login")
public class LoginConteroller extends BaseController {
	private static final Logger logger = Logger.getLogger(LoginConteroller.class);
	@Autowired
	private UserService userService;
	/**
	 * 登陆
	 * <p>
	 * @param userNumber
	 * @param passWord
	 * @return 
	 * @return String
	 * @author ben
	 * @date 2017年9月20日 下午4:25:03 
	 * @Description: TODO
	 */
	@RequestMapping(value = "login", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam(value = "userNumber", required = true) String userNumber,
			@RequestParam(value = "passWord", required = true) String passWord) {
		try {
			ApiCenterUser user = this.userService.getUserByUserNumber(userNumber);
			if(user==null) {
				return Response.fail("账号不存在");
			}
			if(!user.getUserPassword().equals(passWord)) {//就是这api管理,没必要加密密码
				return Response.fail("密码错误");
			}
			return Response.ok(user, "登陆成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("LoginConteroller.login[登陆],参数:userNumber:" + userNumber);
			return Response.error();
		}
	}
}
