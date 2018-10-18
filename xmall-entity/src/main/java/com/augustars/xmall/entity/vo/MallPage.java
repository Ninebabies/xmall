package com.augustars.xmall.entity.vo;

import java.io.Serializable;
import java.util.List;

public class MallPage<E> implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pageNum;					// 当前页码
	private Integer pageSize;					// 每页显示数量
	private List<E> list;						// 分页列表
	private Long totalCount;					// 总数量
	private Integer totalPage;					// 总数量
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
}
