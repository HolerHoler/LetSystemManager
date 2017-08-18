package com.let.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.let.function.ExcelServiceImpl;
import com.let.function.IExcelService;
import com.let.po.User;
import com.let.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Resource(name = "loginService")
	private LoginService loginService;
	private Map<String, Object> result;// 返回登陆结果
	private String fileName;// 导出文件名
	private IExcelService excelService = new ExcelServiceImpl();

	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName)
			throws UnsupportedEncodingException {
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		this.fileName = fileName;
	}

	public InputStream getLoginInputStream() throws IOException {
		String[] headerName = { "用户名", "密码", "点券" };
		List list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		InputStream loginInputStream = excelService.getExcelInputStream("user",
				headerName, list);

		return loginInputStream;
	}

	// 登陆
	public String tryLogin() {
		User getUserByUsername = loginService.findUserByUsername(user
				.getUsername());
		System.out.println(user.getUsername());
		if (getUserByUsername == null) {
			addFieldError("username", "用户名不存在");
			return INPUT;
		} else {
			System.out.println(getUserByUsername.getUsername());
			if (getUserByUsername.getPassword().equals(user.getPassword())) {
				System.out.println(ServletActionContext.getRequest());
				ServletActionContext.getRequest().getSession()
						.setAttribute("user", getUserByUsername);
				User user = (User) ServletActionContext.getRequest()
						.getSession().getAttribute("user");
				return "loginSuccess";
			} else {
				addFieldError("password", "密码错误");
				return INPUT;
			}
		}
	}

	// 注销
	public String exitLogin() {
		result = new HashMap<String, Object>();
		result.put("message", "success");
		System.out.println("action"
				+ ServletActionContext.getRequest().getSession()
						.getAttribute("user"));
		if (ServletActionContext.getRequest().getSession().getAttribute("user") != null) {
			ServletActionContext.getRequest().getSession()
					.removeAttribute("user");
			System.out.println("退出成功");
			return "exit";
		}
		return "exit";
	}

	public String ajaxLogin() {
		User getUserByUsername = loginService.findUserByUsername(user
				.getUsername());
		result = new HashMap<String, Object>();
		if (getUserByUsername == null) {
			// addFieldError("username", "用户名不存在");
			super.addActionError(super.getText("login.message.failed"));
			result.put("message", "用户名不存在");
		} else {
			System.out.println(getUserByUsername.getUsername());
			if (getUserByUsername.getPassword().equals(user.getPassword())) {
				ServletActionContext.getRequest().getSession()
						.setAttribute("username", user.getUsername());
				result.put("message", "success");
				System.out.println(result);
				return "ajaxLoginSuccess";
			} else {
				// addFieldError("password", "密码错误");
				result.put("message", "密码错误");
				System.out.println(result);

			}
		}
		return SUCCESS;
	}

	public String exportLogin() throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH：mm：ss_");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		// 获取系统当前时间
		String str = df.format(now);
		System.out.print(str);
		setFileName(str + "user");
		return "export";

	}

}
