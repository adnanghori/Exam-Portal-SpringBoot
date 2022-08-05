package com.springboot.exam.portal.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.exam.portal.service.implementation.UserDetailsServiceAdapter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceAdapter userDetailsServiceAdapter;
	@Autowired
	private JwtUtil jwtutil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		// checking null and format
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
			jwtToken = requestTokenHeader.substring(7);
			System.out.println(jwtToken);
			try {
				username = this.jwtutil.extractUsername(jwtToken);
				System.out.println(username);
				
			}catch (ExpiredJwtException e) {
				// TODO: handle exception
				System.out.println("Expired");
			} 
			
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
			else {
				System.out.println("Token not validated , Invalid");
			}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails = this.userDetailsServiceAdapter.loadUserByUsername(username);
			if(this.jwtutil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		else {
			System.out.println("Token Not Valid");
		}
		filterChain.doFilter(request, response);
		}
		
		
	}
	
		
	
	
		

