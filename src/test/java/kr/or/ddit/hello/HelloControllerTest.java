package kr.or.ddit.hello;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;
import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

/*
	java - gui swing, awt, java fx, swt
 */

//@ContextConfiguration(locations = {"classpath:/kr/or/ddit/config/spring/application-context.xml",
//							"classpath:/kr/or/ddit/config/spring/root.context.xml"})
//@WebAppConfiguration	// 스프링 환경을 Web 기반의 application Context로 생성
//@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest extends WebTestConfig{
	
	// 스프링 빈 중에 대입 가능한 타입의 스프링 빈을 주입한다
	// 만약 동일한 타입의 스프리 빈이 열개 있을경우 @Quilfier 어노테이션을 통해
	// 특정 스프이 빈의 이름을 지칭할 수 있다
	// ==> Resource 어노테이션 하나를 사용 했을 때와 동일하다
	private HelloController helloController;
	
	// localhost/hello/view
	@Test
	public void viewTest() throws Exception {
		MvcResult mvcResult =  mockMvc.perform(get("/hello/view"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attributeExists("userVo")) // It's called build up pattern which is one sentence
		.andDo(print())
		.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
				
		assertEquals("hello", mav.getViewName());
		
//		UserVo userVo = (UserVo)mav.getModel().get("userVo");
	}
	
//	@Test
//	public void pathVariableTest() throws Exception{
//		MvcResult mvcResult = mockMvc.perform(get("/hello/path/brown"))
//				.andExpect(status().isOk())
//				.andExpect(view().name(""))
//	}

}
