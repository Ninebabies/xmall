package com.augustars.xmall.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.augustars.xmall.transport.CategoryTransport;
@Controller("categoryController")
@RequestMapping("/category")
public class CategoryController extends BaseController {
@Reference(version="1.0.0")
	private CategoryTransport categoryTransport;
public String getCategoryPage()throws Exception{
	return "category/category_page";
}



}
