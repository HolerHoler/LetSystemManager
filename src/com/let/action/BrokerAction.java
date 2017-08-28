package com.let.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.let.function.BrokerExportService;
import com.let.function.ExcelServiceImpl;
import com.let.function.IExcelService;
import com.let.po.Broker;
import com.let.po.BrokerHouse;
import com.let.service.BrokerService;
import com.opensymphony.xwork2.ActionSupport;

public class BrokerAction extends ActionSupport {
	@Resource(name = "brokerService")
	private BrokerService brokerService;
	private Long BrokerID;// ������id
	private Long HouseID;// ����id
	private Broker broker;// �����˶���
	private List<Broker> brokerList;// �������б�
	private BrokerHouse brokerHouse;
	private Map<String, Object> result;// ���ؽ��
	private String fileName;// �����ļ���
	private String delIdArray = new String();// ��ȡ����ɾ��id

	public Long getBrokerID() {
		return BrokerID;
	}

	public void setBrokerID(Long brokerID) {
		BrokerID = brokerID;
	}

	public Long getHouseID() {
		return HouseID;
	}

	public void setHouseID(Long houseID) {
		HouseID = houseID;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public List getBrokerList() {
		return brokerList;
	}

	public void setBrokerList(List brokerList) {
		this.brokerList = brokerList;
	}

	public BrokerHouse getBrokerHouse() {
		return brokerHouse;
	}

	public void setBrokerHouse(BrokerHouse brokerHouse) {
		this.brokerHouse = brokerHouse;
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

	public String add_Broker() {
		brokerService.addBroker(broker);
		return "add";
	}

	// ��ȡ��Ҫ���µ�Broker��Ϣ
	public String update_Broker() {
		broker = brokerService.getBrokerByID(BrokerID);
		return "update";

	}

	// ���µ�Broker��Ϣ
	public String updated_Broker() {
		brokerService.updateBroker(broker);
		return "updateFinish";

	}

	public String delete_Broker() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		brokerService.deleteBroker(BrokerID);
		return "delete";
	}

	public String list_Broker() {
		brokerList = brokerService.getBrokerByAll();
		System.out.println(brokerList);
		return "list";
	}

	public String jumpAdd_Broker() {
		return "jumpAdd";
	}

	public InputStream getBrokerInputStream() throws IOException {
		// String[] headerName = { "������id", "֤������", "֤����", "����", "�绰", "������ַ" };

		// InputStream brokerInputStream = excelService.getExcelInputStream(
		// "user", headerName, list);
		List<Broker> list = brokerService.getBrokerByAll();
		// ����POI�����
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HSSFWorkbook workBook = BrokerExportService.export(list);
		workBook.write(os);
		InputStream brokerInputStream = new ByteArrayInputStream(
				os.toByteArray());
		os.close();
		return brokerInputStream;
	}

	public String export_Broker() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH��mm��ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// ��ȡϵͳ��ǰʱ��
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "broker");
		return "export";
	}

	public String batchDel_Broker() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		System.out.println(delIdArray);
		brokerService.batchDelBroker(delIdArray);
		return "batchDel";
	}
}
