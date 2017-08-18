package com.let.function;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface HSSFExcelService {
	public HSSFWorkbook createBook();

	public HSSFSheet createSheet(HSSFWorkbook createbook, String sheetName);// 创建一个sheet

	public HSSFRow writeRow(HSSFSheet sheet, Integer rowNum);

	public void writeCell(HSSFRow row, Integer colNum, Object object);
}
