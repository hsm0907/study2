package com.study.member.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberDeleteController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		String viewPage = "/WEB-INF/view/member/memberDelete.jsp";
		
		String mem_id = request.getParameter("mem_id");

		Member member = new Member();
		
		member.setMem_id(mem_id);
		
		int cnt = memberServiceImpl.delMember(member);

		
		if(cnt > 0) {
			request.setAttribute("message", "회원삭제 되었습니다.");
		}else {
			request.setAttribute("message", "회원삭제가 실패하였습니다.");
		}
		
		return viewPage;
	}

}
