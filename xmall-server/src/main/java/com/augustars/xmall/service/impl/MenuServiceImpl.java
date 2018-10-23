package com.augustars.xmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.augustars.xmall.dao.MenuDao;
import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.Node;
import com.augustars.xmall.service.MenuService;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
	@Resource(name="menuDao")
	private MenuDao menuDao;
	
	
	public List<Menu> getMenuListByRole(Role role) throws Exception {
//		根据角色获取所有的一级菜单,一级菜单没有父级null
		List<Menu> menuList=menuDao.findFristMenuListByRole(role.getRoleId());
		System.out.println("-------------------------------");
		for (Menu menu : menuList) {
			System.out.println("--------------"+menu.getText());
		}
//		将获得的一级菜单列表进行循环，获得每个人以及菜单的二级菜单集合
		if(menuList != null && menuList.size() > 0) {
			for (Menu frist : menuList) {
				List<Menu> childMenuList = menuDao.findChildMenuListByRoleParent(role.getRoleId(),frist.getMenuId());
				frist.setChildMenuList(childMenuList);
			}
		}
		return menuList;
	}
	
	
	
	public List<Node> getNodeList(Long roleId) throws Exception{
		List<Node> nodeList=new ArrayList<Node>();
//		取出所有的菜单集合
		List<Menu> menuList=menuDao.findAll(new Sort(Direction.ASC, "sortOrder"));
//		将Menu转换成Node
		List<Menu> roleMenuList = menuDao.findMenuListByRole(roleId);
//		将Menu转换成Node
		if(menuList != null && menuList.size() > 0) {
			for(Menu menu : menuList) {
				Node node = new Node();
				node.setId(menu.getMenuId());
				node.setName(menu.getText());
				if(menu.getParent() != null) {
					node.setpId(menu.getParent().getMenuId());
					node.setOpen(false);
				}else {
					node.setpId(0l);;
					node.setOpen(true);
				}
				if (roleMenuList.contains(menu)) {
					node.setChecked(true);
				} else {
					node.setChecked(false);
				}
				
				nodeList.add(node);
			}
		}
		return nodeList;
	}
}
