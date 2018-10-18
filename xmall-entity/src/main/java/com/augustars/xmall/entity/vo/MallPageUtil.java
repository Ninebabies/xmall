package com.augustars.xmall.entity.vo;

import org.springframework.data.domain.Page;

public class MallPageUtil {
	public static <T> MallPage<T> parsetToMallPage(Page<T> page){
		MallPage<T> mallPage = new MallPage<T>();
		mallPage.setPageNum(page.getNumber() + 1);
		mallPage.setPageSize(page.getSize());
		mallPage.setTotalCount(page.getTotalElements());
		mallPage.setTotalPage(page.getTotalPages());
		return mallPage;
	}
}
