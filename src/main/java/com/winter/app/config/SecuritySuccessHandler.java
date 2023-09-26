package com.winter.app.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("==============authentication : {}==============",authentication);
		
		log.info("==============PathInfo : {}==============",request.getPathInfo());
		
		log.info("==============requestURI : {}==============",request.getRequestURI());
		
		log.info("==============requestURL : {}==============",request.getRequestURL());
		
		
		request.getPathInfo();
		
		response.sendRedirect("/");
		
		
	}

	
	
}
