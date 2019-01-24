package com.spatome.applet.util.business;

import org.apache.commons.lang3.RandomUtils;

import com.spatome.applet.util.HttpUtil;

//@Slf4j
public class ZjUtil {
	private static volatile ZjUtil instance;
	private ZjUtil() {
	};
	public static ZjUtil getInstance() {
		if (instance == null) {
			synchronized (HttpUtil.class) {
				if (instance == null) {
					instance = new ZjUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * @param totalCount	总数
	 * @param canDrawCount	能领取数
	 * @return
	 * 随机了一个
	 */
	public boolean draw(long totalCount, long canDrawCount){
		long randomValue = RandomUtils.nextLong(0, totalCount);
		if(randomValue<canDrawCount){
			return true;
		}else{
			return false;
		}
	}
}
