package co.yedam.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;
import co.yedam.member.service.MemberService;
import co.yedam.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		// 전체리스트
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo = new MemberVO();
		String sql = "SELECT *FROM MEMBER";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setuId(rs.getString("u_id"));
				vo.setuPassword(rs.getString("u_password"));
				vo.setuName(rs.getString("u_name"));
				vo.setuTel(rs.getInt("u_tel"));
				vo.setuAddress(rs.getString("u_address"));
				vo.setuBirth(rs.getString("u_birth"));
				members.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return members;
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// 한명분 조회
		String sql = "SELECT * FROM MEMBER WHERE U_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getuId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setuId(rs.getString("u_id"));
				vo.setuPassword(rs.getString("u_password"));
				vo.setuName(rs.getString("u_name"));
				vo.setuTel(rs.getInt("u_tel"));
				vo.setuAddress(rs.getString("u_address"));
				vo.setuBirth(rs.getString("u_birth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// 회원등록
				String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
				int r = 0;
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getuId());
					psmt.setString(2, vo.getuPassword());
					psmt.setString(3, vo.getuName());
					psmt.setInt(4, vo.getuTel());
					psmt.setString(5, vo.getuAddress());
					psmt.setString(6, vo.getuBirth());
					r = psmt.executeUpdate();
					System.out.println(r + "건 입력.");

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return r;
			}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE U_ID=? AND U_PASSWORD=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getuId());
			psmt.setString(2, vo.getuPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setuName(rs.getString("u_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public boolean idCheck(String id) {
		boolean isId = false; // 초기값을 존재하지 않는것을 기준으로 한다.
		String sql = "select u_id from member where u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next())
				isId = true; // 레코드에 값이 존재하면
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return isId;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
