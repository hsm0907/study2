package com.study.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.study.member.vo.Member;

public class MemberDaoJDBC implements IMemberDao {
	// 인터페이스
	// - 객체의 사용방법을 정의한 타입
	
	
	
	// 회원목록
	/* (non-Javadoc)
	 * @see com.studymember.dao.IMemberDao#getMemberList(java.sql.Connection)
	 */
	@Override
	public List<Member> getMemberList(Connection conn) throws SQLException {

		PreparedStatement pstmt = null; // 쿼리를 주면서 실행하고 결과값을 리턴
		ResultSet rs = null;

		List<Member> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT               ");
		sb.append("		 mem_id         ");
		sb.append("	   , mem_name       ");
		sb.append("	   , mem_pw        ");
		sb.append("	   , mem_phone      ");
		sb.append("	   , mem_email      ");
		sb.append("	   , TO_CHAR(reg_date, 'YYYY/MM/DD') AS reg_date ");
		sb.append("	 FROM tb_member2     ");
		sb.append("	 ORDER BY reg_date ASC ");

		try {

			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member(); // 매번 새로운 번지를 사용
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_pwd(rs.getString("mem_pw"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setReg_date(rs.getString("reg_date"));
				list.add(member); // 리스트에 저장
			}

			return list;

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원상세
	/* (non-Javadoc)
	 * @see com.studymember.dao.IMemberDao#getMember(java.sql.Connection, java.lang.String)
	 */
	@Override
	public Member getMember(Connection conn, String mem_id) throws SQLException {

		PreparedStatement pstmt = null; // 쿼리를 주면서 실행하고 결과값을 리턴
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT               ");
		sb.append("		 mem_id         ");
		sb.append("	   , mem_name       ");
		sb.append("	   , mem_pw        ");
		sb.append("	   , mem_phone      ");
		sb.append("	   , mem_email      ");
		sb.append("	   , TO_CHAR(reg_date, 'YYYY/MM/DD HH24:MI') AS reg_date ");
		sb.append("	 FROM tb_member2     ");
		sb.append("WHERE mem_id = ?      ");

		try {

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			Member member = null;

			if (rs.next()) {
				member = new Member(); // 매번 새로운 번지를 사용
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_pwd(rs.getString("mem_pw"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setReg_date(rs.getString("reg_date"));

			}
			return member;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원등록
	/* (non-Javadoc)
	 * @see com.studymember.dao.IMemberDao#insertMember(java.sql.Connection, com.study.member.vo.Member)
	 */
	@Override
	public int insertMember(Connection conn, Member member) throws SQLException {

		PreparedStatement pstmt = null;
		boolean rs = false;

		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO tb_member2 ");
		sb.append("(mem_id, mem_pw, mem_name, mem_phone, mem_email, reg_date ) ");
		sb.append(" VALUES (  ?, ?, ?, ?, ? , SYSDATE ) ");

		try {

			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, member.getMem_id());
			pstmt.setString(idx++, member.getMem_pwd());
			pstmt.setString(idx++, member.getMem_name());
			pstmt.setString(idx++, member.getMem_phone());
			pstmt.setString(idx++, member.getMem_email());

			rs = pstmt.execute();
			return idx;
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원수정
	/* (non-Javadoc)
	 * @see com.studymember.dao.IMemberDao#updateMember(java.sql.Connection, com.study.member.vo.Member)
	 */
	@Override
	public int updateMember(Connection conn, Member member) throws SQLException {

		PreparedStatement pstmt = null; // 쿼리를 주면서 실행하고 결과값을 리턴
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();

		sb.append("UPDATE tb_member2    ");
		sb.append("   SET mem_name  = ? ");
		sb.append("     , mem_phone = ? ");
		sb.append("     , mem_email = ? ");
		sb.append(" WHERE mem_id  = ? ");

		try {

			pstmt = conn.prepareStatement(sb.toString());
			// 구문객체 생성후 파라미터 설정
			pstmt.setString(1, member.getMem_name());
			pstmt.setString(2, member.getMem_phone());
			pstmt.setString(3, member.getMem_email());
			pstmt.setString(4, member.getMem_id());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원삭제
	/* (non-Javadoc)
	 * @see com.studymember.dao.IMemberDao#deleteMember(java.sql.Connection, com.study.member.vo.Member)
	 */
	@Override
	public int deleteMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();

		sb.append(" DELETE FROM tb_member2");
		sb.append(" WHERE mem_id = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, member.getMem_id());

			int cnt = pstmt.executeUpdate();

			return cnt;

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}
}
