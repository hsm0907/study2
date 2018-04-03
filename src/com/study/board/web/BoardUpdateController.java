package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardUpdateController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String viewPage = "/WEB-INF/view/board/boardUpdate.jsp";
		
		BoardServiceImpl boardserviceimpl = new BoardServiceImpl();
		
		Board board = new Board();
		   
		board.setBo_title(request.getParameter("bo_title"));
		board.setBo_passwd(request.getParameter("bo_passwd"));
		board.setBo_email(request.getParameter("bo_email"));
		board.setBo_content(request.getParameter("bo_content"));
		board.setBo_no(Integer.parseInt(request.getParameter("bo_no")));
		
		
		int cnt = boardserviceimpl.modifyBoard(board);
		
		if(cnt > 0) {
			request.setAttribute("message", "게시판등록 성공!!");
		}else {
			request.setAttribute("message", "게시판등록 실패~~");
		}
		
		return viewPage;
	}

}
