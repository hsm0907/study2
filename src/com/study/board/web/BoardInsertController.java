package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardInsertController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String viewPage = "/WEB-INF/view/board/boardInsert.jsp";
		
		BoardServiceImpl boardserviceimpl = new BoardServiceImpl();
		
		Board board = new Board();
			
		/*board.setBo_title(request.getParameter("bo_title"));
		board.setBo_writer(request.getParameter("bo_writer"));
		board.setBo_passwd(request.getParameter("bo_passwd"));
		board.setBo_email(request.getParameter("bo_email"));
		board.setBo_content(request.getParameter("bo_content"));*/
		
		try {
			BeanUtils.populate(board, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		board.setBo_ip(request.getRemoteAddr());
		
		int cnt = boardserviceimpl.registBoard(board);
		
		if(cnt > 0) {
			request.setAttribute("message", "글 등록성공!!!");
		}else {
			request.setAttribute("message", "글 등록실패~~~");
		}
		request.setAttribute("board", board);
		return viewPage;
	}

}
