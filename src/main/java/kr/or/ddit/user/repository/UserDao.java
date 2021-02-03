package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDao {

	// 사용자 조회
	UserVo selectUser(String userid);
	
	// 전체 사용자 조회
	List<UserVo> selectAllUser();
	
	// 페이징 조회
	List<UserVo> selectPagingUser(PageVo pageVo);
	
	// 사용자 카운트
	int selectAllUserCnt();
	
	// 사용자 등록
	int registUser(UserVo userVo);
	
	// 사용자 수정
	int modifyUser(UserVo userVo);
	
	// 사용자 삭제
	int deleteUser(String userid);
	
	

}
