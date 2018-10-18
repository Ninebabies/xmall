package com.augustars.xmall.transport;

import java.util.List;

import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.Node;


public interface MenuTransport {
	/**
	 * Mark：根据用户角色信息，获得该角色所对应的菜单列表，列表呈现树形结构
	 * @param role
	 * @return List<Menu> 用户角色对应菜单列表，呈现树状结构
	 * @throws Exception
	 */
	public List<Menu> getMenuListByRole(Role role)throws Exception;
	public List<Node> getNodeList(Long roleId) throws Exception;
}
