package com.qf.entity;

import java.util.List;

public class Page<T> {

	/**
	 * 当前页
	 */
	private Integer currentPage = 1;
	
	/**
	 * 每页显示的条数
	 */
	private Integer pageSize = 5;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 总条数
	 */
	private Integer totalCount;
	
	/**
	 * 当前页显示的数据
	 */
	private List<T> list;
	
	/**
	 * 点击下一页请求地址
	 */
	private String url;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		this.totalPage =  totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + ", url=" + url + "]";
	}
	
}
