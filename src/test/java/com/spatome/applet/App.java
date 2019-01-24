package com.spatome.applet;

import org.apache.commons.lang3.EnumUtils;

import com.spatome.applet.common.enums.StatusEnum;
import com.spatome.applet.util.business.ZjUtil;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.test2();
	}

	public void test1(String status){
		
		if(status!=null && EnumUtils.isValidEnum(StatusEnum.class, status)){
			System.err.println(true);
		}else{
			System.err.println(false);
		}
	}
	
	public void test2(){
		int t = 0;
		for (int i = 0; i < 100; i++) {
			boolean ret = ZjUtil.getInstance().draw(2, 1);
			if(ret){
				t++;
			}
		}
		System.out.println(t);
	}
}
