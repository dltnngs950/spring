package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(path="allUser", method = RequestMethod.GET)
	public String userlist(Model model){
		
		model.addAttribute("userList", userService.selectAllUser());
		
		return "allUser";	
	}
	
	@RequestMapping(path="allUserTiles", method = RequestMethod.GET)
	public String allUser(Model model){
		
		model.addAttribute("userList", userService.selectAllUser());
		
		return "tiles.user.allUser";	
	}
	
	@RequestMapping("pagingUser")
	public String pagingUser(@RequestParam(defaultValue = "1") int page, 
							 @RequestParam(defaultValue = "5") int pageSize,
							 Model model) {
		
		logger.debug("page : {}, pageSize : {}, price : {}", page, pageSize);		
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		
		int pagination = (int)map.get("pagination");
		
		model.addAttribute("pageVo", (PageVo)map.get("pageVo"));
		model.addAttribute("userlist", map.get("userlist"));
		model.addAttribute("pagination", pagination);
		
		return "user/pagingUser";
	}
	
	@RequestMapping("pagingUserTiles")
	public String pagingUserTiles(@RequestParam(defaultValue = "1") int page, 
								  @RequestParam(defaultValue = "5") int pageSize,
								  Model model) {
		
		logger.debug("page: {}", page);
		logger.debug("pageSize : {}", pageSize);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		
		int pagination = (int)map.get("pagination");
		
		model.addAttribute("pageVo", (PageVo)map.get("pageVo"));
		model.addAttribute("userlist", map.get("userlist"));
		model.addAttribute("pagination", pagination);

		// tiles-definition�� ������ name
		return "tiles.user.pagingUser";
		
	}
	
//	@RequestMapping("pagingUser")
	public String pagingUser(PageVo pageVo) {
		
		logger.debug("pageVo : {}", pageVo);
		
		return "";

	}
	
	@RequestMapping("detailUser")
	public String detailUser(String userid, Model model) {
		logger.debug("userid : {}", userid);
		
		UserVo user = userService.selectUser(userid);
		
		logger.debug("user : {}", user);
		
		model.addAttribute("user", user);
		
		return "user/detailUser";
	}
	
	@RequestMapping("detailUsertiles")
	public String detailUserTiles(String userid, Model model) {
		logger.debug("userid : {}", userid);
		
		UserVo user = userService.selectUser(userid);
		
		logger.debug("user : {}", user);
		
		model.addAttribute("user", user);
		
		return "tiles.user.detailUser";
	}
	
	@RequestMapping(path="modifyUser", method = RequestMethod.GET)
	public String modifyUser(String userid, Model model) {
		
		UserVo user = userService.selectUser(userid);
		
		model.addAttribute("user", user);
		
		return "user/modifyUser";
	}
	
	@RequestMapping(path="modifyUser", method = RequestMethod.POST)
	public String modifyUser(UserVo userVo, Model model, MultipartFile profile) {
		
		logger.debug("userVo : {}", userVo);
		
		try {
			profile.transferTo(
		    new File("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\main\\webapp\\WEB-INF\\views\\profile/"
			+ profile.getOriginalFilename()));
			
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		
		userVo.setFilename(profile.getName());
		userVo.setRealfilename(profile.getOriginalFilename());
		
		int modifyCnt = userService.modifyUser(userVo);
		
		if(modifyCnt == 1) {			
			return "redirect:/user/pagingUser";
		}else {	
			return "user/modifyUser";
		}
		
	}
	
	@RequestMapping(path="registUser", method = RequestMethod.GET)
	public String registUser() {
		return "user/registUser";
	}
	
	// BindingResult ��ü�� command ��ü �ٷ� �ڿ� ���ڷ� ����ؾ� �Ѵ�
	@RequestMapping(path="registUser", method = RequestMethod.POST)
	public String registUser(@Valid UserVo userVo, BindingResult result, Model model, MultipartFile profile) {
		
		logger.debug("userVo : {}", userVo);
		
//		new UserVoValidator().validate(userVo, result);
		
		if(result.hasErrors()) {
			logger.debug("result has error");
			return "user/registUser";
		}
		
		String fileroute = "";
			
		try {
			profile.transferTo(
		    new File("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\main\\webapp\\WEB-INF\\views\\profile/"
			+ profile.getOriginalFilename()));
			
			fileroute = "D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\main\\webapp\\WEB-INF\\views\\profile/";
			
			userVo.setFilename(profile.getOriginalFilename());
			userVo.setRealfilename(fileroute);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}	
		
		int registCnt = 0;
		
		try {
			registCnt = userService.registUser(userVo);
		} catch (Exception e) {
			registCnt = 0;
		}

		logger.debug("registCnt : {}", registCnt);
		
		if(registCnt == 1) {
			model.addAttribute("fileroute", fileroute);
			model.addAttribute("userList", userService.selectAllUser());
			return "allUser";	
		}else {
			model.addAttribute("userVo", userVo);
			return "user/registUser";
		}
		
	}
	
	@RequestMapping(path="deleteUser", method=RequestMethod.POST)
	public String deleteUser(String userid) {
		
		int deleteCnt = 0;
		try {
			deleteCnt = userService.deleteUser(userid);
		}catch(Exception e) {
			deleteCnt = 0;
			e.printStackTrace();
		}

		if(deleteCnt == 1) {
			return "redirect:/user/pagingUser";
		}else {
			
			return "redirect:/user/detailUser?userid=brown";
		}
	}
	
	@RequestMapping("excelDownload")
	public String excelDownload(Model model) {
		
		List<String> header = new ArrayList<>();
		header.add("����� ���̵�");
		header.add("����� �̸�");
		header.add("����� ����");
		
		model.addAttribute("header", header);
		model.addAttribute("data", userService.selectAllUser());
		
		return "userExcelDownloadView";
	}
	
	// localhost/user/profile
	@RequestMapping("profile")
	public void profile(HttpServletResponse response, String userid, HttpServletRequest req) {
		response.setContentType("image");
		
		// userid�Ķ���͸� �̿��Ͽ�
		// usersetvice ��ü�� ���� ������� ���� ���� �̸��� ȹ��
		// ���� ������� ���� ������ �о�鿩 response��ü�� outputStream���� ���� ����
		
		UserVo userVo = userService.selectUser(userid);

		String filename = userVo.getFilename();
		String realFilename = userVo.getRealfilename();
		
		String path = "";
		
		if(userVo.getRealfilename() == null) {
			path = req.getServletContext().getRealPath("/image/unknown.png");
			
		}else {
			path = userVo.getRealfilename();
		}
				
		try {
			ServletOutputStream sos = response.getOutputStream();
			FileInputStream fis = new FileInputStream(new File(realFilename));
			
			byte[] buf = new byte[512];
			
			while(fis.read(buf) != -1) {
				sos.write(buf);
			}
			
			fis.close();
			sos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@RequestMapping("profileDownload")
	public void profileDownload(String userid, HttpServletRequest req, HttpServletResponse resp) {
		
		UserVo userVo= userService.selectUser(userid);
		
		String path = "";
		String filename = "";
		if(userVo.getRealfilename() == null) {
			path = req.getServletContext().getRealPath("/image/unknown.png");
			filename= "unknown.png";
		}
		else {
			path = userVo.getRealfilename();
			filename= userVo.getFilename();
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
		
		// userid �Ķ���͸� �̿��Ͽ�
		// userService ��ü�� ���� ������� ���� ���� �̸��� ȹ��
		// ���� ������� ���� ������ �о�鿩 resp��ü�� outputStream���� ���� ����
		
		logger.debug("path : {} ", path);
		
		try {
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos =  resp.getOutputStream();
			
			byte[] buff = new byte[512];
			
			while(fis.read(buff) != -1) {
				sos.write(buff);
			}
			
			fis.close();
			sos.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}





