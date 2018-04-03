package com.study.member.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.member.vo.Member;
import com.study.util.MyBatisFactory;

public class MemberDaoMyBatis implements IMemberDao{

	//private String namespace = "com.study.member.dao.IMemberDao.";
	
	@Override
	public List<Member> getMemberList(Connection conn) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			// Dao 구현체를 생성하지 않고, 서비스단에서 바로 MyBatis 객체를 이용
			IMemberDao memberDao = session.getMapper(IMemberDao.class);
			List<Member> list = memberDao.getMemberList(conn);
			
			//List<Member> list = session.selectList("com.study.member.dao.IMemberDao.getMemberList");
			return list;
		} finally {
			session.close();
		}
	}

	@Override
	public Member getMember(Connection conn, String mem_id) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			Member member = session.selectOne("com.study.member.dao.IMemberDao.getMember", mem_id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public int insertMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int insertMember = session.insert("com.study.member.dao.IMemberDao.insertMember", member);
			 session.commit();
			return insertMember;
		} finally {
			session.close();
		}
		
	}

	@Override
	public int updateMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int updateMember = session.update("com.study.member.dao.IMemberDao.updateMember", member);
			 session.commit();
			return updateMember;
		} finally {
			session.close();
		}
		
	}

	@Override
	public int deleteMember(Connection conn, Member member) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			 int deleteMember = session.delete("com.study.member.dao.IMemberDao.getMemberList", member);
			return deleteMember;
		} finally {
			session.close();
		}
		
	}

}
