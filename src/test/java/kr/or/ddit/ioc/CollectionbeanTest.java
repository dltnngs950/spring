package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

public class CollectionbeanTest {
	
	// collectionBean ���������� ���������� ���� �Ǿ�����
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;

	@Test
	public void test() {
		assertNotNull(collectionBean);
	}

}
