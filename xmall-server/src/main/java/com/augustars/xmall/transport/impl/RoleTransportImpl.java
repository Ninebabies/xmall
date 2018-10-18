package com.augustars.xmall.transport.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.service.RoleService;
import com.augustars.xmall.transport.RoleTransport;
@Component("roleTransport")
@Service(version="1.0.0")

public class RoleTransportImpl implements RoleTransport{
	@Resource(name="roleService")
	private RoleService roleService;
	
	public MallPage<Role> getRoleListByPage(Integer pageNum, Integer pageSize, String roleName) throws Exception {
		return roleService.getRoleListByPage(pageNum, pageSize, roleName);
	}

	public boolean authc(Long roleId, String[] ids) throws Exception {
		return roleService.authc(roleId, ids);
	}

}
