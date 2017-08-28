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

import com.let.function.HouseExportService;
import com.let.function.RenterExportService;
import com.let.po.HouseInfo;
import com.let.po.Renter;
import com.let.service.HouseService;
import com.opensymphony.xwork2.ActionSupport;

public class HouseAction extends ActionSupport {
	@Resource(name = "houseService")
	private HouseService houseService;
	private Long HouseID;
	private Long LetID;
	private Long BrokerID;
	private HouseInfo house;
	private List houseList;
	private Map<String, Object> result;// 返回结果
	private String fileName;
	private String delIdArray = new String();// 获取批量删除id

	public Long getHouseID() {
		return HouseID;
	}

	public void setHouseID(Long houseID) {
		HouseID = houseID;
	}

	public Long getLetID() {
		return LetID;
	}

	public void setLetID(Long letID) {
		LetID = letID;
	}

	public Long getBrokerID() {
		return BrokerID;
	}

	public void setBrokerID(Long brokerID) {
		BrokerID = brokerID;
	}

	public HouseInfo getHouse() {
		return house;
	}

	public void setHouse(HouseInfo house) {
		this.house = house;
	}

	public List getHouseList() {
		return houseList;
	}

	public void setHouseList(List houseList) {
		this.houseList = houseList;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDelIdArray() {
		return delIdArray;
	}

	public void setDelIdArray(String delIdArray) {
		this.delIdArray = delIdArray;
	}

	public String add_House() {
		houseService.addHouse(house);
		return "add";
	}

	// 获取需要更新的House信息
	public String update_House() {
		house = houseService.getHouseByID(HouseID);
		return "update";

	}

	// 更新的House信息
	public String updated_House() {
		houseService.updateHouse(house);
		return "updateFinish";

	}

	public String delete_House() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		houseService.deleteHouse(HouseID);
		return "delete";
	}

	public String list_House() {
		houseList = houseService.getHouseByAll();
		System.out.println(houseList);
		return "list";
	}

	public String jumpAdd_House() {
		return "jumpAdd";
	}

	public InputStream getHouseInputStream() throws IOException {
		List<HouseInfo> list = houseService.getHouseByAll();
		// 产生POI输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HSSFWorkbook workBook = HouseExportService.export(list);
		workBook.write(os);
		InputStream houseInputStream = new ByteArrayInputStream(
				os.toByteArray());
		os.close();
		return houseInputStream;
	}

	public String export_House() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH：mm：ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 获取系统当前时间
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "house");
		return "export";

	}

	public String batchDel_House() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		System.out.println(delIdArray);
		houseService.batchDelHouse(delIdArray);
		return "batchDel";
	}

}
