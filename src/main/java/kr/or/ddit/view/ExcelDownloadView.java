package kr.or.ddit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.user.model.UserVo;

public class ExcelDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/vnd.ms-excel; charset=utf-8");
		response.setHeader("content-Disposition", "attachement; filename=text.xlsx");
		
		// header : List<String>
		// data : List<UserVo>
		
		List<String> header = (List<String>)model.get("header");
		List<UserVo> data = (List<UserVo>)model.get("data");
		
		// excel ���� ����
		XSSFWorkbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("users");
		
		int rownum = 0;
		int column = 0;
		
		Row row = sheet.createRow(rownum++);
		
		for(String h : header) {
			Cell cell = row.createCell(column++);
			cell.setCellValue(h);
		}
		
		// data��
		for(UserVo user : data) {
			column = 0;
			Row r = sheet.createRow(rownum++);
			r.createCell(column++).setCellValue(user.getUserid());
			r.createCell(column++).setCellValue(user.getUsernm());
			r.createCell(column++).setCellValue(user.getAlias());
		}
		
		book.write(response.getOutputStream());
		
		
	}

}