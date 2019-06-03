//package com.spatome.yj.manager.service.impl.business;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.github.pagehelper.PageHelper;
//import com.spatome.applet.activity.entity.Activity;
//import com.spatome.applet.activity.vo.ActivityVO;
//import com.spatome.applet.common.vo.BaseVO;
//import com.spatome.applet.common.vo.PageVO;
//import com.spatome.applet.util.DUtil;
//import com.spatome.applet.util.SUtil;
//import com.spatome.yj.manager.common.enums.StatusEnum;
//import com.spatome.yj.manager.service.TranService;
//import com.spatome.yj.manager.service.impl.BaseService;
//
//import lombok.extern.slf4j.Slf4j;
//
///** 
// * 活动
// * 
// * 列表
// */
//@Service
//@Slf4j
//public class Tran10015ServiceImpl extends BaseService implements TranService {
//
//	@Override
//	@Transactional
//	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
//		BaseVO<PageVO<ActivityVO>> result = new BaseVO<PageVO<ActivityVO>>();
//		PageVO<ActivityVO> pageVO = new PageVO<ActivityVO>();
//		result.setBody(pageVO);
//
//		log.debug("获取参数");
//		int currentPage = StringUtils.isBlank(request.get("currentPage")) ? 1 : Integer.valueOf(request.get("currentPage"));
//		int pageSize = StringUtils.isBlank(request.get("pageSize")) ? 10 : Integer.valueOf(request.get("pageSize"));
//
//		String ownerNo = request.get("ownerNo");
//		log.debug("检查参数");
//		Map<String, String> paramMap = new HashMap<String, String>();
//		paramMap.put("ownerNo", ownerNo);
//		super.checkNotEmpty(paramMap);
//
//		log.debug("===========================业务处理=========================");
//		pageVO.setPage(currentPage, pageSize);
//		PageHelper.startPage(Integer.valueOf(currentPage), Integer.valueOf(pageSize), false);
//		PageHelper.orderBy("id DESC");
//		Activity activityQ = new Activity();
//		activityQ.setOwnerNo(ownerNo);
//		activityQ.setStatus(StatusEnum.ON.name());
//		List<Activity> recordList = daoFactory.getActivityMapper().selectByBean(activityQ);
//
//		for (Activity record : recordList) {
//			ActivityVO VO = new ActivityVO();
//			VO.setActivityId(record.getId());
//			VO.setActivityName(record.getActivityName());
//			VO.setEnterpriseName(record.getEnterpriseName());
//			VO.setAllowDayCount(SUtil.NTS(record.getAllowDayCount()));
//			VO.setCreateTime(DUtil.formatDateApp(record.getCreateTime()));
//			VO.setStatus(record.getStatus());
//
//			pageVO.getList().add(VO);
//		}
//
//		return result;
//	}
//}
