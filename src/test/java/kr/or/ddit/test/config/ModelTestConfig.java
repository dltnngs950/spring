package kr.or.ddit.test.config;

import org.junit.runner.RunWith;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/kr/or/ddit/config/spring/root-context.xml",
									"classpath:/kr/or/ddit/config/spring/datasource-context.xml"} )
public class ModelTestConfig {

	// ddd
	
}
