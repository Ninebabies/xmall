package com.augustars.xmall.transport;

import com.augustars.xmall.entity.User;
import com.augustars.xmall.entity.vo.MallPage;

public interface UserTransport {
	public User getUserByLogin(String loginName) throws Exception;
	public MallPage<User> getUserListByPage(Integer pageNum, Integer pageSize, String username) throws Exception;
	public boolean changeStatus(Long userId, String statusCode) throws Exception;

}
