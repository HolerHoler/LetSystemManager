package test;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.let.dao.BrokerHouseDao;
import com.let.po.Broker;
import com.let.po.HouseInfo;
import com.let.po.Renter;
import com.let.po.User;
import com.let.service.BrokerHouseService;
import com.let.service.BrokerService;
import com.let.service.HouseService;
import com.let.service.LoginService;
import com.let.service.RenterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
// 使用junit4进行测试
public class Test {
	@Resource(name = "brokerService")
	private BrokerService brokerService;
	@Resource(name = "renterService")
	private RenterService renterService;
	@Resource(name = "houseService")
	private HouseService houseService;
	@Resource(name = "loginService")
	private LoginService loginService;
	@Resource(name = "brokerHouseService")
	private BrokerHouseService brokerHouseService;
	@Resource(name = "brokerHouseDao")
	private BrokerHouseDao brokerHouseDao;

	public void addData() {

		for (int i = 0; i < 10; i++) {
			Broker broker = new Broker();
			broker.setCredentials_type("身份证");
			broker.setCredentials_id("12346" + i);
			broker.setPersonName("pzh" + i);
			broker.setTelephone("0222212" + i);
			broker.setWork_address("光华走" + i);
			brokerService.addBroker(broker);

			Renter renter = new Renter();
			renter.setCredentials_type("身份证");
			renter.setCredentials_id("12346" + i);
			renter.setPersonName("pzh" + i);
			renter.setTelephone("0222212" + i);
			renterService.addRenter(renter);

			HouseInfo house = new HouseInfo();
			house.setHouseName("画好" + i);
			house.setType("普通" + i);
			house.setDesign("三房" + i);
			house.setSize(130.50);
			house.setRent(5000.50);
			house.setRent_method("合租");
			house.setRent_remand("押一付三");
			house.setDirection("东南向");
			house.setAddress("广州" + i);
			house.setFloor("5/6");
			house.setDecoration("豪华");
			house.setFacilities("电视,电脑");
			house.setDescription("海景房");
			house.setState('Y');
			houseService.addHouse(house);
		}

	}

	@org.junit.Test
	public void createRelation() {
		System.out.println(brokerHouseDao);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println(ctx.getBean("BrokerHouseAction"));

	}
}
