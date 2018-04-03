package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberEditController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		String viewPage = "/WEB-INF/view/member/memberEdit.jsp";
		
		Member member = memberServiceImpl.getMember(request.getParameter("mem_id"));
		request.setAttribute("member", member);
		
		
		return viewPage;
	}
	
	
}
