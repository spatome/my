package com.spatome.applet;

import java.util.List;

import com.spatome.applet.util.convert.JUtil;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.test();
	}

	public void test(){
		String s = "[\"aaa\",null,\"ccc\"]";

		List<String> ss = JUtil.toList(s, String.class);
		
		for (String obj:ss) {
			System.out.println(obj);
			if(obj==null){
				System.out.println("1");
			}else{
				System.out.println("2");
			}
		}
	}
	
}
