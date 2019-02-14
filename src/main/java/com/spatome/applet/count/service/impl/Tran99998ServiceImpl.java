package com.spatome.applet.count.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.common.constants.RedisConstants;
import com.spatome.applet.count.entity.ActivityCountItem;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.util.DUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 测试 
 */
@Service
@Slf4j
public class Tran99998ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String dateStr = request.get("dateStr");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("drawCount", drawCount);
		super.checkNotEmpty(paramMap);

		Date date = DUtil.parseShortFormat(dateStr);
		long time = date.getTime();

		log.debug("===========================业务处理=========================");
		System.out.println("==============================");

		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(Long.valueOf(activityId));
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);

		List<Long> itemIdSet = new ArrayList<Long>();
		for (ActivityCountItem f : activityCountItemList) {
			itemIdSet.add(f.getId());
		}

		for (int i = 0; i < 24; i++) {
			String hDateStr = DUtil.formatOrderDate(new Date(time+(i*60*60*1000)));
			int count = RandomUtils.nextInt(100);
			for (int j = 0; j < count; j++) {
				Long itemId = itemIdSet.get(RandomUtils.nextInt(itemIdSet.size()));
				super.stringRedisTemplate.boundHashOps(RedisConstants.APPLET_COUNT_H+activityId+":"+itemId).increment(hDateStr, 1L);
			}
		}

		return result;
	}
}
