package com.study.member.web;

import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.beanutils.BeanUtils;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberUpdateController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		String viewPage = "/WEB-INF/view/member/memberUpdate.jsp";
		
		String mem_id = request.getParameter("mem_id");
		// 아이디가 널, 비어있으면 회원목록을 리다이렉트
		if(mem_id == null || mem_id.trim().equals("")) {
			return "redirect:/member/memberList.do";
		}
		
		// JSP에서 useBean, setProperty 를 사용해서 파라미터를 빈에 자동으로 입력~~
		// 그런데 .. java에서는 ???, 직접 seter 를 이용하는건 너무 힘듬
		// BeanUtils
		
		Member member = new Member();
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		/*member.setMem_id(request.getParameter("mem_id"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_phone(request.getParameter("mem_phone"));
		member.setMem_email(request.getParameter("mem_email"));*/
		
		int cnt = memberServiceImpl.modifyMember(member);
		if(cnt > 0) {
			request.setAttribute("message", "회원수정을 완료했습니다.");
		}else {
			request.setAttribute("message", "회원수정에 실패하였습니다.");
		}
		return viewPage;
	}
	
	
}
