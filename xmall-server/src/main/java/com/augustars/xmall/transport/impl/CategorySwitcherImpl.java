package com.augustars.xmall.transport.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.augustars.xmall.entity.Category;
import com.augustars.xmall.service.CategoryService;
import com.augustars.xmall.transport.CategoryTransport;
@Component("categorySwitcher")
@Service(version="1.0.0")
public class CategorySwitcherImpl implements CategoryTransport{
	@Resource(name="categoryService")
	private CategoryService categoryService;
	public List<Category> getCategoryListByPage(Integer pageNum, Integer pageSize, String categoryName)
			throws Exception {
		return categoryService.getCategoryListByPage(pageNum,pageSize,categoryName);
	}

}
