package com.spatome.applet.count.vo.charts;

import java.util.ArrayList;
import java.util.List;

public class LineVO {

	private List<String> categories;
	private List<Item> list;

	public List<String> getCategories() {
		if(categories == null){
			categories = new ArrayList<String>();
		}
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Item> getList() {
		if(list == null){
			list = new ArrayList<Item>();
		}
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public static class Item {
		private Long itemId;
		private String name;
		private List<String> data;

		public Long getItemId() {
			return itemId;
		}

		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getData() {
			if(data == null){
				data = new ArrayList<String>();
			}
			return data;
		}

		public void setData(List<String> data) {
			this.data = data;
		}
	}
}
