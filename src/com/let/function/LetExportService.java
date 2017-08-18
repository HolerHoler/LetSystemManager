package com.let.function;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.let.po.LetInfo;

public class LetExportService {
	static String[] headerName = { "租约id", "租约名字", "房子id", "房子名字", "房子地址",
			"租客id", "租客名字", "经纪人id", "经纪人名字", "开始时间", "租赁时长", "结束时间" };

	public static HSSFWorkbook export(List<LetInfo> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("let");
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
			LetInfo let = list.get(i);
			row.createCell(0).setCellValue(let.getId());
			row.createCell(1).setCellValue(let.getLetName());
			row.createCell(2).setCellValue(let.getHouseInfo().getId());
			row.createCell(3).setCellValue(let.getHouseInfo().getHouseName());
			row.createCell(4).setCellValue(let.getHouseInfo().getAddress());
			row.createCell(5).setCellValue(let.getRenter().getId());
			row.createCell(6).setCellValue(let.getRenter().getPersonName());
			row.createCell(7).setCellValue(let.getBroker().getId());
			row.createCell(8).setCellValue(let.getBroker().getPersonName());
			row.createCell(9).setCellValue(let.getBeginTime().toString());
			row.createCell(10).setCellValue(let.getDayNum());
			row.createCell(11).setCellValue(let.getEndTime().toString());
		}
		return wb;
	}
}
