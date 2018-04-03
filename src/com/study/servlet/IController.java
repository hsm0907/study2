package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException; 
	
}
