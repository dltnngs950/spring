package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserService {

	// ����� ��ȸ
	UserVo selectUser(String userid);
	
	// ��ü ����� ��ȸ
	List<UserVo> selectAllUser();
	
	// ����¡ ��ȸ
	Map<String, Object> selectPagingUser(PageVo pageVo);
	
	// ����� ���
	int registUser(UserVo userVo);
	
	// ����� ����
	int modifyUser(UserVo userVo);
	
	// ����� ����
	int deleteUser(String userid);
}
