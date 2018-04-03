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
import com.study.util.PagingVO;

public class BoardListController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardserviceimpl = new BoardServiceImpl();
		String viewPage = "/WEB-INF/view/board/boardList.jsp";
		BoardSearch boardSearch = new BoardSearch();
		
		try {
			// BeanUtils 활용 
			// Bean의 유용한 메서드 populate 값을 그대로 넣어주는것
			//
			BeanUtils.populate(boardSearch, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} {
			
		}
		/*String cp = request.getParameter("currentPage");
		if(cp != null && !cp.trim().equals("")) {
			boardSearch.setCurrentPage(Integer.parseInt(cp));
		}*/
		
		boardSearch.setting(boardserviceimpl.getBoardCount(boardSearch));
		
		List<Board> list = boardserviceimpl.getBoardList(boardSearch);
		request.setAttribute("board", list);
		request.setAttribute("search", boardSearch);
		
		return viewPage;
	}

}
