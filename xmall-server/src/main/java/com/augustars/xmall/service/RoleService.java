package com.augustars.xmall.service;

import com.augustars.xmall.entity.Role;
import com.augustars.xmall.entity.vo.MallPage;


public interface RoleService {

	public MallPage<Role> getRoleListByPage(Integer pageNum, Integer pageSize, String roleName) throws Exception;
	public boolean authc(Long roleId, String[] ids) throws Exception;
}
