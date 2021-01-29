package kr.or.ddit.user.repository;

import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

// <bean id="" class=""
// @Repository���� ���ٸ� ������ ���� ����� ������ �� �̸����� class�̸����� ù���ڸ� �ҹ��ڷ� ��
// ���ڿ��� ������ ���� �̸����� �����ȴ�
// UserDaoImpl ==> userDaoImpl

// UserDao / UserDaoImple	 ==> @Resource(name="userDaoImpl")
// UserDaoI / UserDao 	  	 ==> @Resource(name="userDao")

@Repository("UserDao")
public class UserDaoImpl implements UserDao{

	@Override
	public UserVo getUser(String userid) {
		// ������ �����ͺ��̽����� ��ȸ�� �ؾ��ϳ�, ���� �ʱ�ܰ��
		// ������ �Ϸ���� ����, ���� Ȯ���Ϸ��� �ϴ� ����� ������ ���״Ͼ�� ������ ���߱� ����
		// new �����ڸ� ���� ������ vo ��ü�� ��ȯ
		
		return new UserVo("brown", "����");
	}

}
