package com.winter.app.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.winter.app.board.PostVO;
import com.winter.app.member.MemberVO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class SecurityLogoutAdd implements LogoutHandler{
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		
		log.info("====== Logout Add =============");
	
		this.logoutForKakao2(response);
		
	}
	
	//web-client
	private void useWebClient() {
		
		WebClient webClient = WebClient.builder()
							 .baseUrl("https://jsonplaceholder.typicode.com")
							 .build();
		Mono<ResponseEntity<PostVO>> res = webClient.get()
				.uri("posts/1")
				.retrieve()
				.toEntity(PostVO.class);
		
		PostVO postVO =res.block().getBody();
	
		log.info("+++WebClient {}",postVO);
	}
	

	//카카오계정과 함꼐 로그인
	private void logoutForKakao2(HttpServletResponse reponse) {
		//RestTemplate restTemplate = new RestTemplate();
		StringBuffer sb=new StringBuffer();
		sb.append("https://kauth.kakao.com/oauth/logout?");
		sb.append("client_id=");
		sb.append("4e7b74d40e4c6ba1b6f3ce4bb316c65a");
		sb.append("&logout_redirect_uri=");
		sb.append("http://localhost:84/member/kakaologout");
		
		//ResponseEntity<String> res=restTemplate.getForEntity(sb.toString(), String.class);
		
		//log.info("+++카카오계정과로그아웃+++",res.getBody());
		try {
			reponse.sendRedirect(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	

	private void logoutForKakao(Authentication authentication) {
		RestTemplate restTemplate = new RestTemplate();
		MemberVO memberVO = (MemberVO)authentication.getPrincipal();
		
		log.info("---------- AccessToken {} -------", memberVO.getAccessToken());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded");
		//headers.add("Authorization", "Bearer "+memberVO.getAccessToken());
		headers.add("Authorization", "KakaoAK 9373492f2a19ef2466eb4338dcf725ea");
		
		MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
		params.add("target id type", "user id");
		params.add("target_id",memberVO.getName());

		HttpEntity<MultiValueMap<String, String>>req= new HttpEntity<>(null);
		ResponseEntity<String>res=restTemplate.postForEntity("http://kakao.com/v1/user/logout", req, null);
	
		String result = res.getBody();
		
		log.info("==================로그아웃 ID {}",result);
		
	}

	

	public void userRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
	
//		parameter
		MultiValueMap<String, String> params=new LinkedMultiValueMap<>();
		params.add("postId", "1");
		
		
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(params,null);
//      결과가 하나일 떄		
//		ResponseEntity<PostVO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",PostVO.class,req);
//	
//		PostVO result=res.getBody();

		
//		결과가 여러개일 때
//		List<PostVO> res = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",List.class,req);
	
		ResponseEntity<String> res=restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments?postId=1",String.class,req);
		
		log.info("********Comments List : {}********",res);
		
	}
	
	

}
