package com.augustars.xmall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.base.controller.BaseController;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.transport.RoleTransport;
import com.augustars.xmall.util.ConstantUtil;
@Controller("roleController")
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Reference(version="1.0.0")
	private RoleTransport roleTransport;
	
	@RequestMapping(value="/list/{pageNum}/{roleName}")
	public ModelAndView getRoleListByPage(@PathVariable("pageNum")Integer pageNum,@PathVariable("roleName")String roleName) throws Exception{
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if(pageNum == null || pageNum < 1) {
			pageNum = ConstantUtil.PAGE_NUM;
		}
		if(roleName == null || "0".equals(roleName) || "".equals(roleName.trim())) {
			roleName = null;
		}else {
			resultMap.put("roleName", roleName);
		}
		MallPage<Role> Page = roleTransport.getRoleListByPage(pageNum, ConstantUtil.PAGE_SIZE, roleName);
		resultMap.put("page", Page);
		return new ModelAndView("role/role_list", resultMap);
	}
	@RequestMapping(value="/authcList", method=RequestMethod.GET)
	public ModelAndView getAuthcList(Long roleId) throws Exception{
		return null;
	}
	
	@RequestMapping(value="/authc", method=RequestMethod.GET)
	public boolean authc(Long roleId, String nodeIds) throws Exception{
		//截取所有的权限
		String[] ids= nodeIds.split("-");
		if (ids != null && ids.length > 0) {
			boolean flag=roleTransport.authc(roleId, ids);
			return flag;
		}
		return false;
	}
}
