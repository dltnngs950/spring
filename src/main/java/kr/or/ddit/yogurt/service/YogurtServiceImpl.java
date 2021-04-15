package kr.or.ddit.yogurt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.yogurt.model.CycleVo;
import kr.or.ddit.yogurt.repository.YogurtDao;

@Service("yogurtService")
public class YogurtServiceImpl implements YogurtService{
	
	@Resource(name="yogurtDao")
	private YogurtDao dao;
	

	@Override
	public List<CycleVo> selectCycle() {
		
		return dao.selectCycle();
	}
	
	

}
