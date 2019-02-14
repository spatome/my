//package com.spatome.applet.activity.service.impl.business;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.activity.entity.ActivityCount;
//import com.spatome.applet.activity.entity.ActivityCountItem;
//import com.spatome.applet.activity.service.TranService;
//import com.spatome.applet.activity.service.impl.BaseService;
//import com.spatome.applet.activity.vo.ActivityCountVO;
//import com.spatome.applet.activity.vo.ActivityItemVO;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.util.DUtil;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动抓阄
// * 基本增删改查
// * 
// * 查询
// */
//@Service
//@Slf4j
//public class Tran10013ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<ActivityCountVO> result = new BaseVO<ActivityCountVO>();
//		ActivityCountVO VO = new ActivityCountVO();
//		result.setBody(VO);
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		ActivityCount record = daoFactory.getActivityCountMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if (record == null) {
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//
//		VO.setActivityId(record.getId());
//		VO.setActivityName(record.getActivityName());
//		VO.setDescs(record.getDescs());
//		VO.setCreateTime(DUtil.formatDateApp(record.getCreateTime()));
//		VO.setStatus(record.getStatus());
//
//		ActivityCountItem activityCountItemQ = new ActivityCountItem();
//		activityCountItemQ.setActivityId(record.getId());
//		List<ActivityCountItem> itemList = daoFactory.getActivityCountItemMapper().selectByBean(activityCountItemQ);
//		for (ActivityCountItem f : itemList) {
//			ActivityItemVO itemVO = new ActivityItemVO();
//			itemVO.setItemId(f.getId());
//			itemVO.setItemName(f.getItemName());
//			VO.getItemList().add(itemVO);
//		}
//		
//		return result;
//	}
//}
