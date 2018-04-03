package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberListController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		
		List<Member> list = memberServiceImpl.getMemberList();
		request.setAttribute("list", list);
		String viewPage = "/WEB-INF/view/member/memberList.jsp";
		
		return viewPage;
	}
	
	
}
