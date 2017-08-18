package com.let.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO �Զ����ɵķ������
		System.out.println("����������");
	}

	@Override
	public void init() {
		// TODO �Զ����ɵķ������
		System.out.println("��������ʼ��");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO �Զ����ɵķ������
		ActionContext context = invocation.getInvocationContext();
		Object user = context.getSession().get("user");
		System.out.println("������ִ��");
		if (user != null) {
			return invocation.invoke();
		} else {
			context.put("tip", "�㻹û��½�����ȵ�½");
			return Action.LOGIN;
		}
	}

}
