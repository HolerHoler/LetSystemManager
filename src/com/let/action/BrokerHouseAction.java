package com.let.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
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

import com.let.function.BrokerHouseExportService;
import com.let.function.RenterExportService;
import com.let.po.Broker;
import com.let.po.BrokerHouse;
import com.let.po.HouseInfo;
import com.let.po.Renter;
import com.let.service.BrokerHouseService;
import com.let.service.BrokerService;
import com.let.service.HouseService;
import com.opensymphony.xwork2.ActionSupport;

public class BrokerHouseAction extends ActionSupport {
	@Resource(name = "brokerHouseService")
	private BrokerHouseService brokerHouseService;
	@Resource(name = "brokerService")
	private BrokerService brokerService;
	@Resource(name = "houseService")
	private HouseService houseService;
	private Map<String, Object> result;// ���ؽ��

	private Integer BrokerHouseID;
	private Broker broker;
	private HouseInfo house;
	private BrokerHouse brokerHouse;
	private List<BrokerHouse> brokerHouseList;
	private String fileName;

	public Integer getBrokerHouseID() {
		return BrokerHouseID;
	}

	public void setBrokerHouseID(Integer brokerHouseID) {
		BrokerHouseID = brokerHouseID;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public HouseInfo getHouse() {
		return house;
	}

	public void setHouse(HouseInfo house) {
		this.house = house;
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

	public String add_BrokerHouse() {
		brokerHouseService.addBrokerHouse(brokerHouse);
		return "add";
	}

	// ��ȡ��Ҫ���µ�brokerHouse��Ϣ
	public String update_BrokerHouse() {
		brokerHouse = brokerHouseService.getBrokerHouseByID(BrokerHouseID);
		return "update";

	}

	// ���µ�brokerHouse��Ϣ
	public String updated_BrokerHouse() {
		brokerHouseService.updateBrokerHouse(brokerHouse);
		return "updateFinish";

	}

	public String delete_BrokerHouse() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		System.out.println(BrokerHouseID);
		brokerHouseService.deleteBrokerHouse(BrokerHouseID);
		return "delete";
	}

	public String list_BrokerHouse() {
		brokerHouseList = brokerHouseService.getBrokerHouseByAll();
		System.out.println(brokerHouseList);
		return "list";
	}

	public String ajax_BrokerHouse() {
		result = new HashMap<String, Object>();
		if (brokerHouse.getBroker().getId() != null) {
			System.out.println("broker" + brokerHouse.getBroker().getId());
			broker = brokerService.getBrokerByID(brokerHouse.getBroker()
					.getId());
			result.put("broker", broker);
		} else {
			result.put("broker", null);
		}
		if (brokerHouse.getHouse().getId() != null) {
			System.out.println("house" + brokerHouse.getHouse().getId());
			house = houseService.getHouseByID(brokerHouse.getHouse().getId());
			result.put("house", house);
		} else {
			result.put("house", null);
		}
		result.put("message", "haha");
		return "ajaxBrokerHouse";
	}

	public String jumpAdd_BrokerHouse() {
		return "jumpAdd";
	}

	public InputStream getBrokerHouseInputStream() throws IOException {
		List<BrokerHouse> list = brokerHouseService.getBrokerHouseByAll();
		// ����POI�����
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HSSFWorkbook workBook = BrokerHouseExportService.export(list);
		workBook.write(os);
		InputStream brokerHouseInputStream = new ByteArrayInputStream(
				os.toByteArray());
		os.close();
		return brokerHouseInputStream;
	}

	public String export_BrokerHouse() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH��mm��ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// ��ȡϵͳ��ǰʱ��
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "brokerHouse");
		return "export";

	}

}
