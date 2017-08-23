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

import com.let.function.LetExportService;
import com.let.function.RenterExportService;
import com.let.po.Broker;
import com.let.po.BrokerHouse;
import com.let.po.HouseInfo;
import com.let.po.LetInfo;
import com.let.po.Renter;
import com.let.service.BrokerHouseService;
import com.let.service.BrokerService;
import com.let.service.HouseService;
import com.let.service.LetInfoService;
import com.let.service.RenterService;
import com.opensymphony.xwork2.ActionSupport;

public class LetAction extends ActionSupport {
	@Resource(name = "letInfoService")
	private LetInfoService letInfoService;
	@Resource(name = "brokerHouseService")
	private BrokerHouseService brokerHouseService;
	@Resource(name = "brokerService")
	private BrokerService brokerService;
	@Resource(name = "renterService")
	private RenterService renterService;
	@Resource(name = "houseService")
	private HouseService houseService;
	private Integer LetID;
	private Integer BrokerID;
	private Integer RenterID;
	private Integer HosueID;

	private LetInfo letInfo;
	private Broker broker;
	private Renter renter;
	private HouseInfo houseInfo;
	private BrokerHouse brokerHouse;
	private List<BrokerHouse> brokerHouseList;
	private List<BrokerHouse> brokerHouseListByHouseID;
	private Map<String, Object> result;// 返回结果
	private String fileName;
	private String delIdArray = new String();// 获取批量删除id

	private List<LetInfo> letList;

	public Integer getLetID() {
		return LetID;
	}

	public void setLetID(Integer letID) {
		LetID = letID;
	}

	public Integer getBrokerID() {
		return BrokerID;
	}

	public void setBrokerID(Integer brokerID) {
		BrokerID = brokerID;
	}

	public Integer getRenterID() {
		return RenterID;
	}

	public void setRenterID(Integer renterID) {
		RenterID = renterID;
	}

	public Integer getHosueID() {
		return HosueID;
	}

	public void setHosueID(Integer hosueID) {
		HosueID = hosueID;
	}

	public LetInfo getLetInfo() {
		return letInfo;
	}

	public void setLetInfo(LetInfo letInfo) {
		this.letInfo = letInfo;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	public List<LetInfo> getLetList() {
		return letList;
	}

	public void setLetList(List<LetInfo> letList) {
		this.letList = letList;
	}

	public BrokerHouse getBrokerHouse() {
		return brokerHouse;
	}

	public void setBrokerHouse(BrokerHouse brokerHouse) {
		this.brokerHouse = brokerHouse;
	}

	public List<BrokerHouse> getBrokerHouseList() {
		return brokerHouseList;
	}

	public void setBrokerHouseList(List<BrokerHouse> brokerHouseList) {
		this.brokerHouseList = brokerHouseList;
	}

	public List<BrokerHouse> getBrokerHouseListByHouseID() {
		return brokerHouseListByHouseID;
	}

	public void setBrokerHouseListByHouseID(
			List<BrokerHouse> brokerHouseListByHouseID) {
		this.brokerHouseListByHouseID = brokerHouseListByHouseID;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getDelIdArray() {
		return delIdArray;
	}

	public void setDelIdArray(String delIdArray) {
		this.delIdArray = delIdArray;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String add_Let() {
		letInfoService.addLet(letInfo);
		return "add";
	}

	// 获取需要更新的let信息
	public String update_Let() {
		brokerHouseList = brokerHouseService.getBrokerHouseByAll();
		letInfo = letInfoService.getLetByID(LetID);
		return "update";

	}

	// 更新的let信息
	public String updated_Let() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		letInfoService.updateLet(letInfo);
		return "updateFinish";

	}

	public String delete_Let() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		letInfoService.deleteLet(LetID);
		return "delete";
	}

	public String list_Let() {
		letList = letInfoService.getLetByAll();
		System.out.println(letList);
		return "list";
	}

	public String jumpAdd_Let() {
		return "jumpAdd";
	}

	public String bh_Let() {
		brokerHouseList = brokerHouseService.getBrokerHouseByAll();
		System.out.println(brokerHouseList);
		return "bh_list";
	}

	public String ajaxHouse_Let() {
		result = new HashMap<String, Object>();
		System.out.println("house" + letInfo.getHouseInfo().getId());
		houseInfo = houseService.getHouseByID(letInfo.getHouseInfo().getId());
		brokerHouseList = brokerHouseService.getBrokerHouseByHouseID(letInfo
				.getHouseInfo().getId());
		System.out.println(brokerHouseListByHouseID);
		result.put("house", houseInfo);
		result.put("brokerHouseList", brokerHouseList);
		result.put("message", "haha");
		return "ajaxHouse";
	}

	public String ajaxRenter_Let() {
		result = new HashMap<String, Object>();
		System.out.println(letInfo.getRenter().getId());
		if (letInfo.getRenter().getId() != null) {
			renter = renterService.getRenterByID(letInfo.getRenter().getId());
			result.put("renter", renter);
		} else {
			result.put("renter", null);
		}
		result.put("message", "haha");
		return "ajaxRenter";

	}

	public String ajaxBroker_Let() {
		result = new HashMap<String, Object>();
		System.out.println(letInfo.getBroker().getId());
		if (letInfo.getBroker().getId() != null) {
			broker = brokerService.getBrokerByID(letInfo.getBroker().getId());
			result.put("broker", broker);
		} else {
			result.put("broker", null);
		}
		result.put("message", "haha");
		return "ajaxBroker";

	}

	public InputStream getLetInputStream() throws IOException {
		List<LetInfo> list = letInfoService.getLetByAll();
		// 产生POI输出流
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HSSFWorkbook workBook = LetExportService.export(list);
		workBook.write(os);
		InputStream letInputStream = new ByteArrayInputStream(os.toByteArray());
		os.close();
		return letInputStream;
	}

	public String export_Let() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH：mm：ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 获取系统当前时间
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "let");
		return "export";
	}

	public String batchDel_Let() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		System.out.println(delIdArray);
		letInfoService.batchDelLet(delIdArray);
		return "batchDel";
	}

}
