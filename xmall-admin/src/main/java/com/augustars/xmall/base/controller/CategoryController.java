package com.augustars.xmall.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.entity.Category;
import com.augustars.xmall.transport.CategoryTransport;
import com.augustars.xmall.util.ConstantUtil;
@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
@Reference(version="1.0.0")
	private CategoryTransport categoryTransport;
public String getCategoryPage()throws Exception{
	return "category/category_page";
}
@RequestMapping(value="/list",method=RequestMethod.GET)
@ResponseBody
public Map<String, Object> getCategoryListByPage(Integer pageNum,Integer pageSize,String categoryName) throws Exception{
	Map<String, Object> resultMap = new HashMap<String, Object>();
	//对于分页信息的处理
	if (pageNum == null || pageNum < 1) {
		pageNum = ConstantUtil.PAGE_NUM;		
	}
	if (pageSize == null || pageSize < 1) {
		pageNum = ConstantUtil.PAGE_SIZE;
	}
	if (categoryName != null && !"".equals(categoryName.trim())) {
		resultMap.put("categoryName", categoryName);
	}else {
		resultMap.put("categoryName", "");
	}
	List<Category> categoryList = categoryTransport.getCategoryListByPage(pageNum,pageSize,categoryName);
	resultMap.put("data", categoryList);
	return resultMap;
}


}
