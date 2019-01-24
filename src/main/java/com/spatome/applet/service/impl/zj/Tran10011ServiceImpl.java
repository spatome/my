package com.spatome.applet.service.impl.zj;
//package com.spatome.applet.service.impl.basic;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spatome.applet.entity.ActivityZj;
//import com.spatome.applet.service.TranService;
//import com.spatome.applet.service.impl.BaseService;
//import com.spatome.applet.vo.BaseVO;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动抓阄
// * 基本增删改查
// * 
// * 激活、关闭
// */
//@Service
//@Slf4j
//public class Tran10011ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<Object> result = new BaseVO<Object>();
//
//		log.debug("获取参数");
//		String activityId = request.get("activityId");
//		String status = request.get("status");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("activityId", activityId);
//		paramMap.put("status", status);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		switch (status) {
//		case "ON":
//			break;
//		case "OFF":
//			break;
//		case "STOP":
//			break;
//		default:
//			result.setCodeMessage("9999", "未定义状态");
//			return result;
//		}
//
//		ActivityZj record = daoFactory.getActivityZjMapper().selectByPrimaryKey(Long.valueOf(activityId));
//		if(record==null){
//			log.warn("活动{{}}不存在", activityId);
//			result.setCodeMessage("9999", "活动不存在");
//			return result;
//		}
//		if(record.getStatus().equals(status)){
//			return result;
//		}
//
//		ActivityZj updateActivityZj = new ActivityZj();
//		updateActivityZj.setId(record.getId());
//		updateActivityZj.setUpdateTime(new Date());
//		updateActivityZj.setStatus(status);
//		daoFactory.getActivityZjMapper().updateByPrimaryKeySelective(updateActivityZj);
//
//		return result;
//	}
//}
