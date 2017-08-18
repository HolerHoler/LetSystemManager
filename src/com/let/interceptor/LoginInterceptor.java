package com.let.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		System.out.println("拦截器销毁");
	}

	@Override
	public void init() {
		// TODO 自动生成的方法存根
		System.out.println("拦截器初始化");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO 自动生成的方法存根
		ActionContext context = invocation.getInvocationContext();
		Object user = context.getSession().get("user");
		System.out.println("拦截器执行");
		if (user != null) {
			return invocation.invoke();
		} else {
			context.put("tip", "你还没登陆，请先登陆");
			return Action.LOGIN;
		}
	}

}
