package com.augustars.xmall.controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.base.controller.BaseController;
import com.augustars.xmall.entity.User;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.transport.UserTransport;
import com.augustars.xmall.util.ConstantUtil;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Reference(version="1.0.0")
	private UserTransport userTransport;
	
	@RequestMapping(value="/userLogin", method=RequestMethod.GET)
	public String getUserLoginForm() throws Exception {
		return "user/user_login_form";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginError() throws Exception {
		System.out.println("认证失败！");
//		String url=request.getContextPath()+"user/userLogin";
		RedirectView view = new RedirectView(request.getContextPath() + "/user/login");
		return new ModelAndView(view);
	}
	@RequestMapping(value="/list/{pageNum}/{username}")
	public ModelAndView getUserListForIndex(@PathVariable("pageNum")Integer pageNum, @PathVariable("username")String username) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (pageNum < 1) {
			pageNum = ConstantUtil.PAGE_NUM;
		}
		if ("".equals(username.trim()) || "0".equals(username.trim())) {
			username = null;
		} else {
			resultMap.put("username", username);
		}
		MallPage<User> mallPage = userTransport.getUserListByPage(pageNum, ConstantUtil.PAGE_SIZE, username);
		resultMap.put("page", mallPage);
		return new ModelAndView("user/user_list", resultMap);
	}
	
	@RequestMapping(value="/status", method=RequestMethod.PUT)
	@ResponseBody
	public boolean chanageStatus(Long userId, String statusCode) throws Exception {
		return userTransport.changeStatus(userId, statusCode);
	}

}
