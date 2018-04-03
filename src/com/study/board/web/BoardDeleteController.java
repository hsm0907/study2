package com.study.board.web;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardDeleteController implements IController{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String viewPage = "/WEB-INF/view/board/boardDelete.jsp";
		
		BoardServiceImpl boardserviceimpl = new BoardServiceImpl();
		
		String bo_no = request.getParameter("bo_no");
		
		Board board = new Board();
		
		board.setBo_no(Integer.parseInt(bo_no));
		
		int cnt = boardserviceimpl.delBoard(board);
		
		if( cnt > 0) {
			request.setAttribute("message", "게시판 삭제 성공!!!");
		}else {
			request.setAttribute("message", "게시판 삭제 실패 ~~~");
		}
		
		return viewPage;
	}

}
