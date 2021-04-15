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

	// @AutoWired(name="userService")
	// *****************************
	
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
	
	
	// userServiceCon 스프링 빈이 정삭적으로 생성 되었는지 테스트
	@Test
	public void userServiceConsTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(userServiceCons);
	}
	
	@Test
	public void beanScopeTest() {
		// 디자인 패턴 개념으로 보면 두개의 객체는 한 클래스로부터 나왔으므로 동일 해야한다
		assertEquals(userService, userServiceCons);

	}
	
	@Test
	public void beanScopeTest2() {

		// 디자인 패턴 개념으로 보면 두개의 객체는 한 클래스로부터 나왔으므로 동일 해야한다
		assertEquals(userService, userService2);
		
	}
	
	@Test
	public void beanScopePrototypeTest() {

		// 동일한 userServicePrototype 빈을 주입 ( scope : prototype )
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
