package com.augustars.xmall.transport.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.augustars.xmall.entity.User;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.service.UserSerivce;
import com.augustars.xmall.transport.UserTransport;
@Component("userSwitcher")
@Service(version="1.0.0")
public class UserTransportImpl implements UserTransport {
	@Resource(name="userService")
	private UserSerivce userService;

	public User getUserByLoginName(String loginName) throws Exception {
		User user = userService.getUserByLoginName(loginName);
		System.out.println("userService");
		return user;
	}

	public MallPage<User> getUserListByPage(Integer pageNum, Integer pageSize, String username) throws Exception {
		return userService.getUserListBypage(pageNum, pageSize, username);
	}

	public boolean changeStatus(Long userId, String statusCode) throws Exception {
		return userService.changeStatus(userId, statusCode);
	}

	public User getUserByLogin(String loginName) throws Exception {
		return null;
	}
}
