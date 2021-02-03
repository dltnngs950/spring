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
//@WebAppConfiguration	// ������ ȯ���� Web ����� application Context�� ����
//@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest extends WebTestConfig{
	
	// ������ �� �߿� ���� ������ Ÿ���� ������ ���� �����Ѵ�
	// ���� ������ Ÿ���� ������ ���� ���� ������� @Quilfier ������̼��� ����
	// Ư�� ������ ���� �̸��� ��Ī�� �� �ִ�
	// ==> Resource ������̼� �ϳ��� ��� ���� ���� �����ϴ�
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
