package com.winter.app.config;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("========== Exception : {} ===============",exception);
		
		String message="로그인 실패";
		
		if(exception instanceof InternalAuthenticationServiceException) {
			message="login.fail.nouser";
		}
		
		if(exception instanceof BadCredentialsException) {
			message="login.fail.notpassword";
		}
		
		if(exception instanceof AccountExpiredException) {
			message="계정 유효 기간 완료 관리자에게문의";
		}
		if(exception instanceof LockedException) {
			message="블럭된 계정입니다 관리자에게 문의";
		}
		if(exception instanceof CredentialsExpiredException) {
			
			message="비밀번호 유효기간 만료";
		}
		if(exception instanceof DisabledException) {
			message="휴면 계정";
		}
		if(exception instanceof AuthenticationCredentialsNotFoundException) {
			message="인증이 안됌";
		}
		message =URLEncoder.encode(message,"UTF-8");
		response.sendRedirect("/member/login?message="+message);
	}

	
	
}
