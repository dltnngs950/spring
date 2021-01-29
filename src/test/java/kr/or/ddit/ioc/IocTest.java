package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.service.UserService;

@ContextConfiguration("classpath:/kr/or/ddit/ioc/ioc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IocTest {

	@Resource(name="userServiceCons")
	private UserService userServiceCons;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="userService")
	private UserService userService2;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype;
	
	@Resource(name="userServicePrototype")
	private UserService userServicePrototype2;
	
	@Resource(name="dbConfig")
	private DbConfig dbConfig;
	
	
	// userServiceCon ������ ���� ���������� ���� �Ǿ����� �׽�Ʈ
	@Test
	public void userServiceConsTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(userServiceCons);
	}
	
	@Test
	public void beanScopeTest() {
		// ������ ���� �������� ���� �ΰ��� ��ü�� �� Ŭ�����κ��� �������Ƿ� ���� �ؾ��Ѵ�
		assertEquals(userService, userServiceCons);

	}
	
	@Test
	public void beanScopeTest2() {

		// ������ ���� �������� ���� �ΰ��� ��ü�� �� Ŭ�����κ��� �������Ƿ� ���� �ؾ��Ѵ�
		assertEquals(userService, userService2);
		
	}
	
	@Test
	public void beanScopePrototypeTest() {

		// ������ userServicePrototype ���� ���� ( scope : prototype )
		assertNotEquals(userServicePrototype, userServicePrototype2);
		
	}
	
	@Test
	public void propertyPlaceholderTest() {
		assertNotNull(dbConfig);
		assertEquals("Soohun", dbConfig.getUsername());
		assertEquals("java", dbConfig.getPassword());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbConfig.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbConfig.getDriverClassName());
		
		
	}

}
