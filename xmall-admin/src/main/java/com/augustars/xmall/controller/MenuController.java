package com.augustars.xmall.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.base.controller.BaseController;
import com.augustars.xmall.entity.vo.Node;
import com.augustars.xmall.transport.MenuTransport;

@Controller("menuController")
@RequestMapping("/menu")
public class MenuController extends BaseController{
	@Reference(version="1.0.0")
	private MenuTransport menuTransport;
	
	@RequestMapping(value="/authcList",method=RequestMethod.GET)
	@ResponseBody
	public List<Node> getNodeList(Long roleId) throws Exception{
			return menuTransport.getNodeList(roleId);
	}
	
}
