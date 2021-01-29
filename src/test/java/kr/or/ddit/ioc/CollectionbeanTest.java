package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

public class CollectionbeanTest {
	
	// collectionBean 스프링빈이 정상적으로 생성 되었는지
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;

	@Test
	public void test() {
		assertNotNull(collectionBean);
	}

}
