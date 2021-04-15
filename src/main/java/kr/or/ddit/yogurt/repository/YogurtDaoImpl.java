package kr.or.ddit.yogurt.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.yogurt.model.CycleVo;

@Repository("yogurtDao")
public class YogurtDaoImpl implements YogurtDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<CycleVo> selectCycle() {
		
		return template.selectList("yogurt.selectCycle");
	}

}
