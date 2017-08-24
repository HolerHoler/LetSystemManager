package com.let.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.let.po.User;
import com.let.service.AdminService;
import com.let.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Resource(name = "adminService")
	private AdminService adminService;
	private String old_password;
	private Map<String, Object> result;// 返回结果

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user;
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String jumpAdd_Admin() {
		return "jumpAdd";
	}

	// 修改密码
	public String changePassword_Admin() {
		result = new HashMap<String, Object>();
		User userFromDB = adminService.findUserByUsername(user.getUsername());
		if (old_password.trim().equals(userFromDB.getPassword())) {
			System.out.println("yes");
			result.put("message", "success");
			userFromDB.setPassword(user.getPassword());
			adminService.changePassword(userFromDB);
			if (ServletActionContext.getRequest().getSession()
					.getAttribute("user") != null) {
				ServletActionContext.getRequest().getSession()
						.removeAttribute("user");
				System.out.println("退出成功");
			}
		} else {
			addFieldError("old_password", "密码错误");
			result.put("message", "fail");
			System.out.println("no");
		}
		return SUCCESS;
	}
}
