package com.jman.form_management_project.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jman.form_management_project.common.ENV;
import com.jman.form_management_project.common.MyResponse;
//import com.jman.miniproject.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTConfig {

	
	private static String secret = ENV.Constant.SECRET;
	
//	public String generateToken(User user) {
//
//		long currentTime = System.currentTimeMillis();
//		long expiry = currentTime+60*60*1000;
//
//		Date issuedTime = new Date(currentTime);
//		Date expiredTime = new Date(expiry);
//
//		Claims claims=Jwts.claims()
//					.setIssuer(user.getCustomerEmail())
//					.setIssuedAt(issuedTime)
//					.setExpiration(expiredTime);
//
//		claims.put("type", user.getRole());
//		claims.put("name", user.getFullName());
//		claims.put("email", user.getCustomerEmail());
//
//
//		return Jwts.builder()
//				.setClaims(claims)
//				.signWith(SignatureAlgorithm.HS512, secret)
//				.compact();
//	}
	
	public MyResponse verify(String auth ) {
		MyResponse res = new MyResponse();
		try {			
			
			DecodedJWT decode = JWT.decode(auth);
			if( decode.getExpiresAt().before(new Date())) {
			    System.out.println("token is expired");
			    res.setData("token is expired");
			    res.setStatus(400);
			    return res;
			}
			else {
				Claims claims =Jwts.parser()
						.setSigningKey(secret)
						.parseClaimsJws(auth)
						.getBody();
				res.setData(claims);
				res.setStatus(200);
				return res;
			}
		}
		catch(Exception e)
		{
			res.setData("Invalid Token");
			res.setStatus(400);
			return res;
		}
		
	}
}
