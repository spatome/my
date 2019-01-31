package com.spatome.applet.count.service.impl.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.common.vo.PageVO;
import com.spatome.applet.count.common.enums.StatusEnum;
import com.spatome.applet.count.entity.ActivityCount;
import com.spatome.applet.count.service.TranService;
import com.spatome.applet.count.service.impl.BaseService;
import com.spatome.applet.count.vo.ActivityCountVO;
import com.spatome.applet.util.DUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 统计
 * 
 * 列表
 */
@Service
@Slf4j
public class Tran10015ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<PageVO<ActivityCountVO>> result = new BaseVO<PageVO<ActivityCountVO>>();
		PageVO<ActivityCountVO> pageVO = new PageVO<ActivityCountVO>();
		result.setBody(pageVO);

		log.debug("获取参数");
		int currentPage = StringUtils.isBlank(request.get("currentPage")) ? 1 : Integer.valueOf(request.get("currentPage"));
		int pageSize = StringUtils.isBlank(request.get("pageSize")) ? 10 : Integer.valueOf(request.get("pageSize"));

		String ownerNo = request.get("ownerNo");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ownerNo", ownerNo);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		pageVO.setPage(currentPage, pageSize);
		PageHelper.startPage(Integer.valueOf(currentPage), Integer.valueOf(pageSize), false);
		PageHelper.orderBy("id DESC");
		ActivityCount activityCountQ = new ActivityCount();
		activityCountQ.setOwnerNo(ownerNo);
		activityCountQ.setStatus(StatusEnum.ON.name());
		List<ActivityCount> recordList = daoFactory.getActivityCountMapper().selectByBean(activityCountQ);

		for (ActivityCount f : recordList) {
			ActivityCountVO VO = new ActivityCountVO();
			VO.setActivityId(f.getId());
			VO.setActivityName(f.getActivityName());
			VO.setDescs(f.getDescs());
			VO.setStatus(f.getStatus());
			VO.setCreateTime(DUtil.formatDateApp(f.getCreateTime()));

			pageVO.getList().add(VO);
		}

		return result;
	}
}
