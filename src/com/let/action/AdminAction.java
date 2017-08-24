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
	private Map<String, Object> result;// ���ؽ��

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public User getModel() {
		// TODO �Զ����ɵķ������
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

	// �޸�����
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
				System.out.println("�˳��ɹ�");
			}
		} else {
			addFieldError("old_password", "�������");
			result.put("message", "fail");
			System.out.println("no");
		}
		return SUCCESS;
	}
}
