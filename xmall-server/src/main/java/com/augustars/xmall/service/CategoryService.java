package com.augustars.xmall.service;

import java.util.List;

import com.augustars.xmall.entity.Category;

public interface CategoryService {

	public List<Category> getCategoryListByPage(Integer pageNum, Integer pageSize, String categoryName) throws Exception;

}
