package in.co.sunrays.project0.controller;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Main Controller performs session checking and logging operations before
 * calling any application controller. It prevents any user to access
 * application without login.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */


public class FrontCtl extends HandlerInterceptorAdapter {


	@Autowired
	private MessageSource messageSource;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")==null) {
			Locale locale=null;
			String msg = messageSource.getMessage("message.session", null, locale);
			request.setAttribute("error", msg);
        	String str = request.getServletPath();
        	request.setAttribute("uri",str);
            RequestDispatcher rd = request.getRequestDispatcher("/Login");
            rd.forward(request, response);
            return false;
		}
		return true;
	}

}
