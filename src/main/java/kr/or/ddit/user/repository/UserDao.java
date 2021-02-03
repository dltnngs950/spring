package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDao {

	// ����� ��ȸ
	UserVo selectUser(String userid);
	
	// ��ü ����� ��ȸ
	List<UserVo> selectAllUser();
	
	// ����¡ ��ȸ
	List<UserVo> selectPagingUser(PageVo pageVo);
	
	// ����� ī��Ʈ
	int selectAllUserCnt();
	
	// ����� ���
	int registUser(UserVo userVo);
	
	// ����� ����
	int modifyUser(UserVo userVo);
	
	// ����� ����
	int deleteUser(String userid);
	
	

}
