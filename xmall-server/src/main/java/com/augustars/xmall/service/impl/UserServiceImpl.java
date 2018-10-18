package com.augustars.xmall.service.impl;


import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.augustars.xmall.dao.StatusDao;
import com.augustars.xmall.dao.UserDao;
import com.augustars.xmall.entity.Status;
import com.augustars.xmall.entity.User;
import com.augustars.xmall.entity.vo.MallPage;
import com.augustars.xmall.entity.vo.MallPageUtil;
import com.augustars.xmall.service.UserSerivce;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserSerivce {
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="statusDao")
	private StatusDao statusDao;
	public User getUserByLoginName(
			String loginName) throws Exception {
		return userDao.findUserByLoginName(loginName);
	}   
	
	public MallPage<User> getUserListBypage(Integer pageNum, Integer pageSize, String username) throws Exception {
		Sort sort = new Sort(Direction.ASC,"userId");
		Page<User> page = null;
		if(username == null) {
			 page = userDao.findAll(PageRequest.of(pageNum - 1, pageSize, sort));
		}else {
			page = userDao.findAll(new Specification<User>() {
				public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Predicate predicate = cb.like(root.get("username"), "%" + username +"%");
					return query.where(predicate).getRestriction();
				}
			},PageRequest.of(pageNum - 1, pageSize, sort));
		}
		MallPage<User> mallPage = MallPageUtil.parsetToMallPage(page);
		return mallPage;
	}

	public boolean changeStatus(Long userId, String statusCode) throws Exception {
		// 根据用户主键查找用户对象
				User user = userDao.findUserById(userId);
				// 根据状态码查找状态对象
				Status status = statusDao.findStatusByCode(statusCode);
				// 更新用户
				user.setStatus(status);
				try {
					userDao.save(user);
					return true;
				} catch (Exception e) {
					throw e;
				}
	}			

}
