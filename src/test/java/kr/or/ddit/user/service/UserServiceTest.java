package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.test.config.ModelTestConfig;
import kr.or.ddit.user.model.UserVo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/kr/or/ddit/ioc/ioc.xml")
public class UserServiceTest extends ModelTestConfig{

	
	@Resource(name="userService")
	private UserService userService;
	
	@Test
	public void test() {
		/***Given***/
		String userid="brown";

		/***When***/
		UserVo userVo = userService.selectUser(userid);
		/***Then***/
		assertEquals("브라운", userVo.getUsernm());
	}
	
	@Test
	public void registUser() {
		/***Given***/
		UserVo userVo = new UserVo();

		/***When***/
		int registCnt = userService.registUser(userVo);
		/***Then***/
		
		
		
	}
	
	

}
