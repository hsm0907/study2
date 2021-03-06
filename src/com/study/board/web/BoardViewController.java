package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardViewController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String viewPage = "/WEB-INF/view/board/boardView.jsp";
		
		String bo_no = request.getParameter("bo_no");
		
		BoardServiceImpl boardserviceimpl = new BoardServiceImpl();
		
		Board board = boardserviceimpl.getBoard(Integer.parseInt(bo_no));
		
		request.setAttribute("board", board);
	
		return viewPage;
	}

}
