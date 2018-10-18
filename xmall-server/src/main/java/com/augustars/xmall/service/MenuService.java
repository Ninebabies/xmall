package com.augustars.xmall.service;

import java.util.List;

import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.Node;


public interface MenuService {
	public List<Menu> getMenuListByRole(Role role) throws Exception;
	public List<Node> getNodeList(Long roleId) throws Exception;
	
}
