package com.let.function;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.let.po.HouseInfo;

public class HouseExportService {
	static String[] headerName = { "房子id", "房名", "类型", "设计", "大小", "租金",
			"租赁方法", "租赁要求", "房子坐向", "地址", "楼层", "装修", "配套", "描述", "状态" };

	public static HSSFWorkbook export(List<HouseInfo> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("house");
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
			HouseInfo house = list.get(i);
			row.createCell(0).setCellValue(house.getId());
			row.createCell(1).setCellValue(house.getHouseName());
			row.createCell(2).setCellValue(house.getType());
			row.createCell(3).setCellValue(house.getDesign());
			row.createCell(4).setCellValue(house.getSize());
			row.createCell(5).setCellValue(house.getRent());
			row.createCell(6).setCellValue(house.getRent_method());
			row.createCell(7).setCellValue(house.getRent_remand());
			row.createCell(8).setCellValue(house.getDirection());
			row.createCell(9).setCellValue(house.getAddress());
			row.createCell(10).setCellValue(house.getFloor());
			row.createCell(11).setCellValue(house.getDecoration());
			row.createCell(12).setCellValue(house.getFacilities());
			row.createCell(13).setCellValue(house.getDirection());
			row.createCell(14).setCellValue(String.valueOf(house.getState()));
		}
		return wb;
	}
}
