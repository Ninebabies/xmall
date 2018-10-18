package com.augustars.xmall.transport.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.Node;
import com.augustars.xmall.service.MenuService;
import com.augustars.xmall.transport.MenuTransport;


@Component("menuSwitcher")
@Service(version="1.0.0")
public class MenuTransportImpl implements MenuTransport{
	@Resource(name="menuService")
	private MenuService menuService;
	

	public List<Menu> getMenuListByRole(Role role) throws Exception {
		List<Menu> menuList = menuService.getMenuListByRole(role);
		return menuList;
	}

	public List<Node> getNodeList(Long roleId) throws Exception {
		return menuService.getNodeList(roleId);
	}
}
