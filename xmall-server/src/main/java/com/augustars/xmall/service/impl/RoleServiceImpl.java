package com.augustars.xmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.augustars.xmall.dao.MenuDao;
import com.augustars.xmall.dao.RoleDao;
import com.augustars.xmall.entity.Menu;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.entity.vo.MallPageUtil;
import com.augustars.xmall.service.RoleService;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Resource(name="menuDao")
	private MenuDao menuDao;
	
	public MallPage<Role> getRoleListByPage(Integer pageNum, Integer pageSize, String roleName) throws Exception {
//		MallPage<Role> mallPage = new MallPage<Role>();
		//设定排序字段
		Sort sort =new Sort(Direction.ASC,"roleId");
		//设定分页对象
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		Page<Role> page = null;
		//判断是否有模糊查询
		if(roleName == null) {
			//没有携带查询条件
			page = roleDao.findAll(pageable);
		} else {
			//携带查询条件
			page = roleDao.findAll(new Specification<Role>() {
				public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cd) {
					Predicate predicate= cd.like(root.get("roleName"), "%" + roleName + "%");
					return query.where(predicate).getRestriction();
				}
			},pageable);
		}
		
		// 将page对象的数据穿入XM+allPage中
		MallPage<Role> mallPage = MallPageUtil.parsetToMallPage(page);
		return mallPage;
	}
	public boolean authc(Long roleId,String[] ids)throws Exception{
		List<Menu> menuList = new ArrayList<Menu>();
		//循环Id
		for(String id : ids) {
			Long menuId = Long.parseLong(id);
			Menu menu = menuDao.findMenuById(menuId);
			menuList.add(menu);
		}
		Role role = roleDao.findRoleById(roleId);
		role.setMenuList(menuList);
		roleDao.save(role);
		return true;
	}
}
