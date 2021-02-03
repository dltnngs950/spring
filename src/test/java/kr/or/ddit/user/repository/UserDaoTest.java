package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.config.ModelTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends ModelTestConfig{
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void test() {
		/***Given***/
		String userid="brown";

		/***When***/
		UserVo userVo = userDao.selectUser(userid);
		
		/***Then***/
		assertEquals("ºê¶ó¿î", userVo.getUsernm());
	}

}
