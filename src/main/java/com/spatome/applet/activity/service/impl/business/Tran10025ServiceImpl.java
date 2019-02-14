package com.spatome.applet.activity.service.impl.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.spatome.applet.activity.common.enums.StatusEnum;
import com.spatome.applet.activity.entity.Prize;
import com.spatome.applet.activity.service.TranService;
import com.spatome.applet.activity.service.impl.BaseService;
import com.spatome.applet.activity.vo.PrizeVO;
import com.spatome.applet.common.vo.BaseVO;
import com.spatome.applet.common.vo.PageVO;
import com.spatome.applet.util.DUtil;
import com.spatome.applet.util.SUtil;

import lombok.extern.slf4j.Slf4j;

/** 
 * 奖品
 * 
 * 列表
 */
@Service
@Slf4j
public class Tran10025ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletRequest req, HttpServletResponse res) {
		BaseVO<PageVO<PrizeVO>> result = new BaseVO<PageVO<PrizeVO>>();
		PageVO<PrizeVO> pageVO = new PageVO<PrizeVO>();
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
		Prize prizeQ = new Prize();
		prizeQ.setOwnerNo(ownerNo);
		prizeQ.setStatus(StatusEnum.ON.name());
		List<Prize> recordList = daoFactory.getPrizeMapper().selectByBean(prizeQ);

		for (Prize record : recordList) {
			PrizeVO VO = new PrizeVO();
			VO.setPrizeId(record.getId());
			VO.setPrizeName(record.getPrizeName());
			VO.setPrizeCount(SUtil.NTS(record.getPrizeCount()));
			//VO.setPrizeBalance(record.getPrizeBalance());
			VO.setIsEnter(record.getIsEnter());
			VO.setPrizeIconUrl(record.getPrizeIconName());
			//VO.setPrizeImageUrl(prizeImageUrl);
			VO.setCreateTime(DUtil.formatDateApp(record.getCreateTime()));
			VO.setStatus(record.getStatus());

			pageVO.getList().add(VO);
		}

		return result;
	}
}
