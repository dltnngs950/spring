package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public UserServiceImpl () {}
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}
	
	@Override
	public List<UserVo> selectAllUser() {
		
		return userDao.selectAllUser();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<UserVo> userlist = userDao.selectPagingUser(pageVo);
		int userCnt = userDao.selectAllUserCnt();
		
		int pagination = (int)Math.ceil((double)userCnt / pageVo.getPageSize());
		// (int)Math.ceil( Double.valueOf(resultMap.get("userCnt").toString() ) / pageVo.getPageSize();
		
		resultMap.put("pageVo", pageVo);
		resultMap.put("userlist", userlist);
		resultMap.put("userCnt", userCnt);
		resultMap.put("pagination", pagination);
		
		return resultMap;
	}

	@Override
	public int registUser(UserVo userVo) {
		
		return userDao.registUser(userVo);
	}

	@Override
	public int modifyUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.modifyUser(userVo);
	}

	@Override
	public int deleteUser(String userid) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userid);
	}

	
	

}
