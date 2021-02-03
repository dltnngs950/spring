package kr.or.ddit.login;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.test.config.WebTestConfig;


@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest extends WebTestConfig{

//	private LoginController loginController;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/login/views")) // First of all, call mockMvc Object then use method of perform then get url
		.andExpect(status().isOk()) // and we use method of what value we are expecting now. 
		.andExpect(view().name("login")); 
		// if result is login then this test is successful
	}
	
	@Test
	public void processSuccessTest() throws Exception {
		mockMvc.perform(post("/login/process")
						.param("userid", "brown")
						.param("pass", "brownPass")
						.param("price", "1000"))
			.andExpect(view().name("main"))
			.andDo(print());
	}
	
	@Test
	public void processFailTest() throws Exception {
		mockMvc.perform(post("/login/process")
						.param("userid", "brown")
						.param("pass", "brownPass")
						.param("price", "1000"))
				.andExpect(view().name("redirect:/login/views"))
				.andDo(print());
	}
	

}
