package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberInsertController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		
		Member member = new Member();
				
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pwd(request.getParameter("mem_pwd"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_phone(request.getParameter("mem_phone"));
		member.setMem_email(request.getParameter("mem_email"));
			
		
		int cnt = memberServiceImpl.aaMember(member);
		if(cnt > 0) {
			request.setAttribute("message", "회원가입에 성공하였습니다.");
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");			
		}
			
		String viewPage = "/WEB-INF/view/member/memberInsert.jsp";
		
		return viewPage;
	}
	
	
}
