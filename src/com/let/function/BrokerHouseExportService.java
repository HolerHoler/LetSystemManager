package com.let.function;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.let.po.BrokerHouse;

public class BrokerHouseExportService {
	static String[] headerName = { "经纪人id", "经纪人名字", "房子id", "房子名字" };

	public static HSSFWorkbook export(List<BrokerHouse> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("brokerHouse");
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
			BrokerHouse brokerHouse = list.get(i);
			row.createCell(0).setCellValue(brokerHouse.getBroker().getId());
			row.createCell(1).setCellValue(
					brokerHouse.getBroker().getPersonName());
			row.createCell(2).setCellValue(brokerHouse.getHouse().getId());
			row.createCell(3).setCellValue(
					brokerHouse.getHouse().getHouseName());
		}
		return wb;
	}

}
