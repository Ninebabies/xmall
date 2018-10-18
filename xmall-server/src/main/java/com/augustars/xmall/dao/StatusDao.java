package com.augustars.xmall.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.augustars.xmall.dao.Base.BaseDao;
import com.augustars.xmall.entity.Status;

public interface StatusDao extends BaseDao<Status, Long>{
	@Query("from Status s where s.statusCode=:statusCode")
	public Status findStatusByCode(@Param("statusCode")String statusCode) throws Exception;
}
