package com.study.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.util.MyBatisFactory;

public class BoardDaoMyBatis implements IBoardDao{
	
	private String nameSpace = "com.study.board.dao.IBoardDao."; 
	
	@Override
	public int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			int cnt = session.selectOne(nameSpace + "getBoardCount", boardSearch);
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			List<Board> list = session.selectList(nameSpace + "getBoardList", boardSearch);
			return list;
		} finally {
			session.close();
		}
	}

	@Override
	public Board getBoard(Connection conn, int bo_no) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 Board board = session.selectOne(nameSpace + "getBoard", bo_no);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int cnt = session.insert(nameSpace + "insertBoard", board);
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int updateBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int cnt = session.update(nameSpace + "updateBoard", board);
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int cnt = session.delete(nameSpace + "deleteBoard", board);
			return cnt;
		} finally {
			session.close();
		}
	}

}
