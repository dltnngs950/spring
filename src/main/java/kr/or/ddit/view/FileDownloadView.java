package kr.or.ddit.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

// controller에서 개발자가 model 객체에 realFilename = 실제 디스크에 저장된 경로와 파일명을,
//								  filename = 업로드 당시의 파일명을 속성에 저장
public class FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		// d:/upload/sally.png
		String realFilename = model.get("realFilename").toString();
		String filename = model.get("filename").toString();
		
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		
		ServletOutputStream sos = response.getOutputStream();
		
		FileInputStream fis = new FileInputStream(new File(realFilename));
		
		byte[] buf = new byte[512];
		
		while(fis.read(buf) != -1) {
			sos.write(buf);
		}
		
		fis.close();
		sos.close();
		
	}

}

