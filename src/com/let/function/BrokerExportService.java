package com.let.function;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.let.po.Broker;

public class BrokerExportService {
	static String[] headerName = { "经纪人id", "证件类型", "证件号", "姓名", "电话", "工作地址" };

	public static HSSFWorkbook export(List<Broker> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("broker");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		for (int i = 0; i < headerName.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(headerName[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
			// sheet.SetColumnWidth(i, 100 * 256);
		}

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Broker broker = list.get(i);
			row.createCell(0).setCellValue(broker.getId());
			row.createCell(1).setCellValue(broker.getCredentials_type());
			row.createCell(2).setCellValue(broker.getCredentials_id());
			row.createCell(3).setCellValue(broker.getPersonName());
			row.createCell(4).setCellValue(broker.getTelephone());
			row.createCell(5).setCellValue(broker.getWork_address());
		}
		return wb;
	}
}
