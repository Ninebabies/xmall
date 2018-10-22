package com.augustars.xmall.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.augustars.xmall.dao.CategoryDao;
import com.augustars.xmall.entity.Category;
import com.augustars.xmall.service.CategoryService;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	public List<Category> getCategoryListByPage(Integer pageNum, Integer pageSize, String categoryName)
			throws Exception {
		//设定分页对象
		Page<Category> page = null;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, 
				new Sort(Direction.ASC,"sortOrder"));
		if (categoryName != null && !"".equals(categoryName.trim())) {
			//按条件分页查询
			page = categoryDao.findAll(new Specification<Category>() {
				public Predicate toPredicate(Root<Category> root,CriteriaQuery<?> query,CriteriaBuilder cb) {
					Predicate predicate = cb.like(root.get("categoryName"),"%" + categoryName + "%");
					return query.where(predicate).getGroupRestriction();
				}
			}, pageable);
		}else {
			page = categoryDao.findAll(pageable);
		}
		return page.getContent();
	}

}
