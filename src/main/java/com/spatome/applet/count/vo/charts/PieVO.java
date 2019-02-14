package com.spatome.applet.count.vo.charts;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 饼图
 */
public class PieVO {

	private List<Item> list;

	public List<Item> getList() {
		if(list == null){
			list = new ArrayList<Item>();
		}
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	@Getter
	@Setter
	public static class Item {
		private Long itemId;
		private String name;
		private String data;
	}
}
