package com.let.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.let.function.RenterExportService;
import com.let.function.RenterExportService;
import com.let.po.Renter;
import com.let.po.LetInfo;
import com.let.po.Renter;
import com.let.service.RenterService;

public class RenterAction {
	@Resource(name = "renterService")
	private RenterService renterService;
	private Integer RenterID;
	private Renter renter;
	private List renterList;
	private LetInfo let;
	private Map<String, Object> result;// 返回结果
	private String fileName;// 导出文件名

	public Integer getRenterID() {
		return RenterID;
	}

	public void setRenterID(Integer renterID) {
		RenterID = renterID;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public List getRenterList() {
		return renterList;
	}

	public void setRenterList(List renterList) {
		this.renterList = renterList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LetInfo getLet() {
		return let;
	}

	public void setLet(LetInfo let) {
		this.let = let;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String add_Renter() {
		renterService.addRenter(renter);
		return "add";
	}

	// 获取需要更新的renter信息
	public String update_Renter() {
		renter = renterService.getRenterByID(RenterID);
		return "update";

	}

	// 更新的renter信息
	public String updated_Renter() {
		renterService.updateRenter(renter);
		return "updateFinish";

	}

	public String delete_Renter() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		renterService.deleteRenter(RenterID);
		return "delete";
	}

	public String list_Renter() {
		renterList = renterService.getRenterByAll();
		System.out.println(renterList);
		return "list";
	}

	public String jumpAdd_Renter() {
		return "jumpAdd";
	}

	public InputStream getRenterInputStream() throws IOException {
		List<Renter> list = renterService.getRenterByAll();
		// 产生POI输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HSSFWorkbook workBook = RenterExportService.export(list);
		workBook.write(os);
		InputStream renterInputStream = new ByteArrayInputStream(
				os.toByteArray());
		os.close();
		return renterInputStream;
	}

	public String export_Renter() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH：mm：ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 获取系统当前时间
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "renter");
		return "export";

	}

}
