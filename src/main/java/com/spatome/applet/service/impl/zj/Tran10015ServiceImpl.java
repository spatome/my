package com.spatome.applet.service.impl.zj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.spatome.applet.entity.ActivityZj;
import com.spatome.applet.service.TranService;
import com.spatome.applet.service.impl.BaseService;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.util.SUtil;
import com.spatome.applet.vo.ActivityZjVO;
import com.spatome.applet.vo.BaseVO;
import com.spatome.applet.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动抓阄
 * 
 * 查询
 * 我的
 */
@Service
@Slf4j
public class Tran10015ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<PageVO<ActivityZjVO>> result = new BaseVO<PageVO<ActivityZjVO>>();
		PageVO<ActivityZjVO> pageVO = new PageVO<ActivityZjVO>();
		result.setBody(pageVO);

		log.debug("获取参数");
		int currentPage = StringUtils.isBlank(request.get("currentPage")) ? 1 : Integer.valueOf(request.get("currentPage"));
		int pageSize = StringUtils.isBlank(request.get("pageSize")) ? 10 : Integer.valueOf(request.get("pageSize"));

		String ownerNo = request.get("ownerNo");
		String status = request.get("status");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ownerNo", ownerNo);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		pageVO.setPage(currentPage, pageSize);
		PageHelper.startPage(Integer.valueOf(currentPage), Integer.valueOf(pageSize), false);
		PageHelper.orderBy("id DESC");
		ActivityZj activityZjQ = new ActivityZj();
		activityZjQ.setOwnerNo(ownerNo);
		activityZjQ.setStatus(status);
		List<ActivityZj> activityZjList = daoFactory.getActivityZjMapper().selectByBean(activityZjQ);
		//Page<ActivityZj> page = (Page<ActivityZj>)activityZjList;
		//pageVO.setPage(page);

		for (ActivityZj f : activityZjList) {
			ActivityZjVO VO = new ActivityZjVO();
			VO.setActivityId(f.getId());
			VO.setActivityName(f.getActivityName());
			VO.setTotalCount(SUtil.NTS(f.getTotalCount()));
			VO.setDrawCount(SUtil.NTS(f.getDrawCount()));
			VO.setBeginTime(DUtil.formatShortDate(f.getBeginTime()));
			VO.setEndTime(DUtil.formatShortDate(f.getEndTime()));
			VO.setDescs(f.getDescs());
			VO.setStatus(f.getStatus());
			VO.setCreateTime(DUtil.formatDateApp(f.getCreateTime()));

			pageVO.getList().add(VO);
		}

		return result;
	}
}
