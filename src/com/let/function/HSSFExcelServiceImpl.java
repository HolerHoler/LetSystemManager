package com.let.function;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class HSSFExcelServiceImpl implements HSSFExcelService {
	@Override
	public HSSFWorkbook createBook() {
		// TODO 自动生成的方法存根
		HSSFWorkbook book = new HSSFWorkbook();
		return book;
	}

	@Override
	public HSSFSheet createSheet(HSSFWorkbook createbook, String sheetName) {
		// TODO 自动生成的方法存根
		HSSFSheet sheet = createbook.createSheet(sheetName);
		return sheet;
	}

	@Override
	public HSSFRow writeRow(HSSFSheet sheet, Integer rowNum) {
		// TODO 自动生成的方法存根
		HSSFRow row = sheet.createRow(rowNum);
		return row;
	}

	@Override
	public void writeCell(HSSFRow row, Integer colNum, Object object) {
		// TODO 自动生成的方法存根
		HSSFCell cell = row.createCell(colNum);
		if (object instanceof Date) {
			Date d = (Date) object;
			cell.setCellValue(d);
		}
		if (object instanceof Number) {
			double d = (double) object;
			cell.setCellValue(d);
		}
		if (object instanceof Boolean) {
			Boolean b = (Boolean) object;
			cell.setCellValue(b);
		} else {
			String s = (String) object;
			cell.setCellValue(s);
		}

	}

}
