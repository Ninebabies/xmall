package com.augustars.xmall.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.augustars.xmall.dao.Base.BaseDao;
import com.augustars.xmall.entity.Role;

public interface RoleDao extends BaseDao<Role, Long>{
	@Query(value="from Role r where r.roleId=:roleId")
	public Role findRoleById(@Param("roleId")Long roleId) throws Exception;
}
