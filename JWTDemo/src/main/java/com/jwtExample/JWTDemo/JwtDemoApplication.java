package com.jwtExample.JWTDemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class JwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);

		String secret = "TestAppOnSample";
		String token =
		Jwts.builder()
				.setId("3244645")   //user UnqId
				.setSubject("sample") //username
				.setIssuedAt(new Date(System.currentTimeMillis())) //Createed Tie
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2))) //Expire Time
				.setIssuer("ORGNAME") //Token Provider name
				.signWith(SignatureAlgorithm.HS256, secret.getBytes()) // sec algo, secret
				.compact();

		System.out.println(token);

		//this is for reading the data using claim
		Claims c =
		Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();

		System.out.println(c.getSubject());
		System.out.println(c.getIssuer());
		System.out.println(c.getExpiration());
	}

}
