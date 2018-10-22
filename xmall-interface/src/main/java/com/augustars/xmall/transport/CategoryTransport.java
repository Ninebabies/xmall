package com.augustars.xmall.transport;

import java.util.List;

import com.augustars.xmall.entity.Category;

public interface CategoryTransport {

	public List<Category> getCategoryListByPage(Integer pageNum, Integer pageSize, String categoryName) throws Exception;

}
