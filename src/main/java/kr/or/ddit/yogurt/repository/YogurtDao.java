package kr.or.ddit.yogurt.repository;

import java.util.List;

import kr.or.ddit.yogurt.model.CycleVo;

public interface YogurtDao {
	
	List<CycleVo> selectCycle();

}
