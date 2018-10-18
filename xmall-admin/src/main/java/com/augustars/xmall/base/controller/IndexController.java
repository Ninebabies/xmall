package com.augustars.xmall.base.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.User;
import com.augustars.xmall.transport.MenuTransport;

@Controller
public class IndexController extends BaseController{
	@Reference(version="1.0.0")
	private MenuTransport menuTransport;
	
	//用于处理SpringMVC与Shiro的请求转发冲突
	//主要处理SpringMVC配置文件的"/"请求问题
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getIndex() throws Exception{
//		实现过程：通过用户--》角色--》菜单列表
//		第一步：获取当前的登陆用户
//		User user =(User) session.getAttribute("user");
		
		Role role=((User) session.getAttribute("user")).getRole();
		//第三步：通过角色直接获取角色所对应的所有菜单，会报错：no session
		//原因：session的生命周期是在一次请求来临和结束，若通过role直接获取menuList，
		//	   是多次的进行获取menu，所以当再次获取menu信息时，session已关闭，将会无法再获取到
		//解决办法：通过事务的方式查询表之间关联的信息，获得用户对应的所有的菜单信息	
//		List<Menu> menuList=menuTransport.getMenuListByRole(role);
//		for (Menu menu : menuList) {
//			List<Menu> chlidemenuList = menu.getChildMenuList();
//			System.out.println(menu.getText());
//			for (Menu menu2 : chlidemenuList) {
//				System.out.println(menu2.getText());
//			}
//		}
		//转发到管理员管理界面
//		Map<String, Object> resultMap= new HashMap<String,Object>(); 
//		resultMap.put("menuList", menuList);
		List<Menu> menuList = menuTransport.getMenuListByRole(role);
		System.out.println("resultMap");
		return new ModelAndView("index","menuList", menuList);
	}
	
}
