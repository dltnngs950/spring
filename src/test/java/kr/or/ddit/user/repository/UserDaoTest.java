package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import kr.or.ddit.test.config.ModelTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends ModelTestConfig{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	@Before
	public void setup() {
		
		// initData.sql을 실행 : 스프링에서 제공하는 ResourceDAtabasePoPulator
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		// userDao == new UserDao();
		populator.addScript(new ClassPathResource("/kr/or/ddit/db/initData.sql"));
		
		// populator를 실행
		DatabasePopulatorUtils.execute(populator, null);
		
		// 테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser", "신규사용자", "testPass", 
				"테스트", "d", "d", "dt", "D", "d", new Date(), 1000);	
	}
	
	@Test
	public void test() {
		/***Given***/
		String userid="brown";

		/***When***/
		UserVo userVo = userDao.selectUser(userid);
		
		/***Then***/
		assertEquals("브라운", userVo.getUsernm());
	}

}
