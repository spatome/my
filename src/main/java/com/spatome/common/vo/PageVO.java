package com.spatome.common.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;

public class PageVO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<T> list;
	private int currentPage;
	private int pageSize;
	private long totalCount;

	private T totalRecord;

	public void setPage(Page<?> page) {
		this.currentPage = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.totalCount = page.getTotal();
	}
	public void setPage(int currentPage, int pageSize) {
		this.currentPage = currentPage<=1?1:currentPage;
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

	public List<T> getList() {
		if(list==null){
			list = new ArrayList<T>();
		}
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public T getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(T totalRecord)
	{
		this.totalRecord = totalRecord;
	}
}
