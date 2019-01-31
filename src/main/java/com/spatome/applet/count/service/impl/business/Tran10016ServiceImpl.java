package com.spatome.applet.count.service.impl.business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.count.entity.ActivityCountItem;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;
import com.spatome.applet.count.vo.ActivityItemVO;
import com.spatome.applet.util.convert.JUtil;

import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

/** 
 * 活动抓阄
 * 基本增删改查
 * 
 * 修改 统计项
 */
@Service
@Slf4j
public class Tran10016ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		String items = request.get("items");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		paramMap.put("items", items);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		ActivityCountItem activityCountItemQ = new ActivityCountItem();
		activityCountItemQ.setActivityId(Long.valueOf(activityId));
		List<ActivityCountItem> activityCountItemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);

		Set<Long> itemIdSet = new HashSet<Long>();
		for (ActivityCountItem item : activityCountItemList) {
			itemIdSet.add(item.getId());
		}

		List<ActivityItemVO> itemList = JUtil.toList(items, ActivityItemVO.class);
		for (ActivityItemVO item : itemList) {
			itemIdSet.remove(item.getItemId());

			if(StringUtil.isBlank(item.getItemName())){
				continue;
			}

			if(item.getItemId()==null){
				ActivityCountItem newActivityCountItem = new ActivityCountItem();
				newActivityCountItem.setActivityId(Long.valueOf(activityId));
				newActivityCountItem.setItemName(item.getItemName());
				daoFactory.getActivityCountItemMapper().insertSelective(newActivityCountItem);
			}else{
				ActivityCountItem activityCountItemUpdate = new ActivityCountItem();
				activityCountItemUpdate.setId(item.getItemId());
				activityCountItemUpdate.setItemName(item.getItemName());
				daoFactory.getActivityCountItemMapper().updateByPrimaryKeySelective(activityCountItemUpdate);
			}
		}

		for (Long itemId : itemIdSet) {
			daoFactory.getActivityCountItemMapper().deleteByPrimaryKey(itemId);
		}
		
		return result;
	}
}
