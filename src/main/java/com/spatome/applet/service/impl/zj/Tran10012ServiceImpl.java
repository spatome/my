package com.spatome.applet.service.impl.zj;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.applet.common.enums.StatusEnum;
import com.spatome.applet.entity.ActivityZj;
import com.spatome.applet.service.TranService;
import com.spatome.applet.service.impl.BaseService;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.vo.BaseVO;

import lombok.extern.slf4j.Slf4j;

/** 
 * 活动抓阄
 * 基本增删改查
 * 
 * 修改
 */
@Service
@Slf4j
public class Tran10012ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String activityId = request.get("activityId");
		//String ownerNo = request.get("ownerNo");
		String activityName = request.get("activityName");
		String beginTime = request.get("beginTime");			//开始时间	yyyy-MM-dd HH:mm:ss
		String endTime = request.get("endTime");				//结束时间	yyyy-MM-dd HH:mm:ss
		String descs = request.get("descs");					//活动详情
		String totalCount = request.get("totalCount");			//总数
		String drawCount = request.get("drawCount");			//中奖数
		String imageName = request.get("imageName");			//图片
		String status = request.get("status");					//状态
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("activityId", activityId);
		super.checkNotEmpty(paramMap);

		Date bTime = DUtil.parseFormatNoMM(beginTime);
		Date eTime = DUtil.parseFormatNoMM(endTime);
		Integer tCount = StringUtils.isBlank(totalCount)?null:Integer.valueOf(totalCount);
		Integer dCount = StringUtils.isBlank(drawCount)?null:Integer.valueOf(drawCount);

		log.debug("===========================业务处理=========================");
		if(status!=null && !EnumUtils.isValidEnum(StatusEnum.class, status)){
			result.setCodeMessage("9999", "状态未定义");
			return result;
		}
		ActivityZj record = daoFactory.getActivityZjMapper().selectByPrimaryKey(Long.valueOf(activityId));
		if (record == null) {
			result.setCodeMessage("9999", "活动不存在");
			return result;
		}

		ActivityZj updateActivityZj = new ActivityZj();
		updateActivityZj.setId(record.getId());
		updateActivityZj.setStatus(status);
		updateActivityZj.setActivityName(activityName);
		updateActivityZj.setBeginTime(bTime);
		updateActivityZj.setEndTime(eTime);
		updateActivityZj.setDescs(descs);
		updateActivityZj.setTotalCount(tCount);
		updateActivityZj.setDrawCount(dCount);
		updateActivityZj.setImageName(imageName);
		daoFactory.getActivityZjMapper().updateByPrimaryKeySelective(updateActivityZj);

		return result;
	}
}
