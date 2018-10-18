package com.augustars.xmall.service;

import com.augustars.xmall.entity.User;
import com.augustars.xmall.entity.vo.MallPage;

public interface UserSerivce {
	public User getUserByLoginName(String loginName) throws Exception;
	public MallPage<User> getUserListBypage(Integer pageNum, Integer pageSize, String username) throws Exception;
	public boolean changeStatus(Long userId, String statusCode) throws Exception; 
}
