package com.let.function;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelServiceImpl implements IExcelService {
	private HSSFExcelService excelService = new HSSFExcelServiceImpl();
	private InputStream excelStream;

	@Override
	public InputStream getExcelInputStream(String sheelName,
			String[] headerName, List list) throws IOException {
		// TODO 自动生成的方法存根
		return dealData(sheelName, headerName, list);
	}

	private InputStream dealData(String sheelName, String[] headerName,
			List list) {

		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet(sheelName);
			HSSFRow row = sheet.createRow(0);
			for (int j = 0; j < headerName.length; j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellValue(headerName[j]);
			}
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < headerName.length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(list.get(i).toString());
				}
			}

			// 产生POI输出流
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			workBook.write(os);
			excelStream = new ByteArrayInputStream(os.toByteArray());
			System.out.println(excelStream);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return excelStream;

	}

}
