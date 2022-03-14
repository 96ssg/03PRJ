package co.yedam.eventServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.EventVO.EventVO;
import co.yedam.common.DAO;
import co.yedam.eventService.eventService;

public class eventServiceImpl extends DAO implements eventService {

	PreparedStatement psmt;
	ResultSet rs;
		
	@Override
	public List<EventVO> eventSelectList() {
		String sql = "select * from event order by 1";
		List<EventVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EventVO vo = new EventVO();
				vo.setEventId(rs.getInt("e_id"));
				vo.seteTitle(rs.getString("e_title"));
				vo.seteContent(rs.getString("e_content"));
				vo.seteDate(rs.getString("e_date"));
//				vo.setEventHit(rs.getInt("event_hit"));
				
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
		
	}

	@Override
	public EventVO eventSelect(EventVO vo) {
		String sql = "select * from event where e_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEventId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setEventId(rs.getInt("e_id"));
				vo.seteTitle(rs.getString("e_title"));
				vo.seteContent(rs.getString("e_content"));
				vo.seteDate(rs.getString("e_date"));
				/* vo.setEventHit(rs.getInt("event_hit")); */
				System.out.println("hhh: " + vo.getEventId());

				/*
				 * addCount(vo.getEventId());
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertevent(EventVO vo) {
		// 시퀀스 조회
		int r = 0;
		try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select event_seq.nextval from dual");
		rs.next();
		int id = rs.getInt(1);
		vo.setEventId(id);
		
		String sql = "insert into event(e_id, e_title, e_content, e_date) values(?,?,?,sysdate)";
		
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEventId());
			psmt.setString(2, vo.geteTitle());
			psmt.setString(3, vo.geteContent());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}

		
		


	@Override
	public int updateevent(EventVO vo) {
		String sql = "update event set e_title=?, e_content=? where e_id=?";
		int r = 0; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.geteTitle());
			psmt.setString(2, vo.geteContent());
			psmt.setInt(3, vo.getEventId());
			r = psmt.executeUpdate();
			/* System.out.println(r + "건 변경됨."); */

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int deleteevent(EventVO vo) {
		String sql = "delete from event where e_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEventId());

			r = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}
	
	
	

	/*
	 * public void addCount(int i) { System.out.println("id: " + i); String sql =
	 * "update events set event_hit = event_hit + 1 where e_id=?"; try { psmt =
	 * conn.prepareStatement(sql); psmt.setInt(1, i); int r = psmt.executeUpdate();
	 * System.out.println(r + " qusrud");
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(); }
	 * 
	 * }
	 */
	private void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
