package com.csdj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截验证
 * @author LinKai
 *
 */
public class SysInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (false) {
			//错误跳转
			response.sendRedirect(request.getContextPath()+"/JSP/erorr.jsp");
			//返回
			return false;
		}else {
			//没有错误
			return true;
		}
	}

}
