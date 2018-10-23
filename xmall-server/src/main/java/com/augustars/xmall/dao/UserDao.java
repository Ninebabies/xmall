package com.augustars.xmall.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.augustars.xmall.dao.Base.BaseDao;
import com.augustars.xmall.entity.User;

public interface UserDao extends BaseDao<User, Long> {
	
	@Query("from User u where u.loginName=:loginName")
	public User findUserByLoginName(@Param("loginName")String loginName) throws Exception;

	@Query("from User u where u.userId=:userId")
	public User findUserById(@Param("userId")Long userId)throws Exception;

}
