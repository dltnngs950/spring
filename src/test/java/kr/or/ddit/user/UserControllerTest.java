package kr.or.ddit.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;

public class UserControllerTest extends WebTestConfig{


//	@Test
//	public void pagingUserTest() throws Exception{
//		mockMvc.perform(get("/user/pagingUser").param("p", "1000"))
//					.andExpect(view().name("user/pagingUser"))
//					.andExpect(status().isOk())
//					.andExpect();
//	}
	
//	mockMvc.perform(get("/mvc/fileupload/view"))
//	.andExpect(status().isOk())
//	.andExpect(view().name("file/view"))
//	.andDo(print());

	@Test
	public void detailUserTest() throws Exception{
		mockMvc.perform(get("user/detailUser").param(null, null));
	}
	
}
