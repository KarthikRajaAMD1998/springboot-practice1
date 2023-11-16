package com.jman.form_management_project.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JWTInterceptor implements HandlerInterceptor {

	@Autowired
	JWTConfig jwtconfig;
	
//	private RequestMeta reqMeta;
//	public JWTInterceptor(RequestMeta reqMeta) {
//		this.reqMeta = reqMeta;
//	}


//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("po da "+request.getRequestURI());
//		
//		if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup")))
//		{
//			String auth = request.getHeader("Authorization").substring(7);
//			try {
//			MyResponse res= jwtconfig.verify(auth);
//			Claims claims = (Claims) res.getData();
//			System.out.println(claims);
//			reqMeta.setEmail(claims.get("email").toString());
//			reqMeta.setName(claims.get("name").toString());
//			reqMeta.setType(claims.get("type").toString());
//			
//			}
//			catch(Exception e){
//				System.out.println("va da ");
//				throw new AccessDeniedException("Access Denied");
//			}
//		}
//		
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
//	
	

}
