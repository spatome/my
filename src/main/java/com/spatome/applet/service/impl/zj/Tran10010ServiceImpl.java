package com.spatome.applet.service.impl.zj;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * 增加
 */
@Service
@Slf4j
public class Tran10010ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String ownerNo = request.get("ownerNo");
		String activityName = request.get("activityName");
		String beginTime = request.get("beginTime");			//开始时间	yyyy-MM-dd
		String endTime = request.get("endTime");				//结束时间	yyyy-MM-dd
		String descs = request.get("descs");					//活动详情
		String totalCount = request.get("totalCount");			//总数
		String drawCount = request.get("drawCount");			//中奖数
		String imageName = request.get("imageName");			//图片
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ownerNo", ownerNo);
		paramMap.put("activityName", activityName);
		paramMap.put("beginTime", beginTime);
		paramMap.put("endTime", endTime);
		paramMap.put("totalCount", totalCount);
		paramMap.put("drawCount", drawCount);
		super.checkNotEmpty(paramMap);

		System.out.println(beginTime);
		
		Date bTime = DUtil.parseShortFormat(beginTime);
		Date eTime = DUtil.parseShortFormat(endTime);
		Date date = new Date();

		log.debug("===========================业务处理=========================");
		ActivityZj record = new ActivityZj();
		record.setStatus("ON");
		record.setCreateTime(date);
		record.setUpdateTime(date);
		record.setActivityName(activityName);
		record.setOwnerNo(ownerNo);
		record.setTotalCount(Integer.valueOf(totalCount));
		record.setDrawCount(Integer.valueOf(drawCount));
		record.setImageName(imageName);
		record.setBeginTime(bTime);
		record.setEndTime(eTime);
		//record.setHintNo(hintNo);
		record.setDescs(descs);
		daoFactory.getActivityZjMapper().insertSelective(record);

		result.setBody(String.valueOf(record.getId()));

		return result;
	}
}
