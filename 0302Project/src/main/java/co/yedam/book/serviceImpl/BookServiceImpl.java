package co.yedam.book.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.book.service.BookService;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DAO;

public class BookServiceImpl extends DAO implements BookService {
	PreparedStatement psmt;
	ResultSet rs;

	@Override
	public List<BookVO> bookSelectList() {
		// 전체조회
		String sql = "SELECT * FROM BOOK ORDER BY 1";
		
		List<BookVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setbId(rs.getInt("b_id"));
				vo.setbName(rs.getString("b_name"));
				vo.setbWriter(rs.getString("b_writer"));
				vo.setbContent(rs.getString("b_content"));
				vo.setbRegister(rs.getDate("b_register"));
				vo.setbCompany(rs.getString("b_company"));
				vo.setbPrice(rs.getInt("b_price"));
				vo.setbImage(rs.getString("b_image"));
				vo.setbCountry(rs.getString("b_country"));

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
	public BookVO bookSelect(BookVO vo) {
		
		//책 단건조회
		String sql = "SELECT * FROM BOOK WHERE B_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				
				vo.setbId(rs.getInt("b_id"));
				vo.setbName(rs.getString("b_name"));
				vo.setbWriter(rs.getString("b_writer"));
				vo.setbContent(rs.getString("b_content"));
				vo.setbRegister(rs.getDate("b_register"));
				vo.setbCompany(rs.getString("b_company"));
				vo.setbPrice(rs.getInt("b_price"));
				vo.setbImage(rs.getString("b_image"));
				vo.setbCountry(rs.getString("b_country"));
			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertBook(BookVO vo) {
		// 책등록
		String sql = "INSERT INTO BOOK(B_ID, B_NAME, B_WRITER, B_CONTENT, B_REGISTER, B_COMPANY, B_PRICE, B_IMAGE, B_COUNTRY)"
				+ " VALUES(?,?,?,?,SYSDATE,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			psmt.setString(2, vo.getbName());
			psmt.setString(3, vo.getbWriter());
			psmt.setString(4, vo.getbContent());
			psmt.setString(5, vo.getbCompany());
			psmt.setInt(6, vo.getbPrice());
			psmt.setString(7, vo.getbImage());
			psmt.setString(8, vo.getbCountry());
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
	public int updateBook(BookVO vo) {
		
		// 책 가격 수정
		String sql = "UPDATE BOOK SET B_PRICE=? WHERE B_ID=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbPrice());
			psmt.setInt(2, vo.getbId());
			r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int deleteBook(BookVO vo) {
		
		// 책 정보 삭제
		String sql = "DELETE FROM BOOK WHERE B_ID = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());

			r = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}
	public List<BookVO> selectBookListPaging(int page) {
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   book\r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";

		List<BookVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;

		firstCnt = (page - 1) * 9 + 1;
		lastCnt = (page * 9);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setbId(rs.getInt("b_id"));
				vo.setbName(rs.getString("b_name"));
				vo.setbWriter(rs.getString("b_writer"));
				vo.setbContent(rs.getString("b_content"));
				vo.setbRegister(rs.getDate("b_register"));
				vo.setbCompany(rs.getString("b_company"));
				vo.setbPrice(rs.getInt("b_price"));
				vo.setbImage(rs.getString("b_image"));
				vo.setbCountry(rs.getString("b_country"));

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}
	
	public List<BookVO> selectBookListPagingCountry(int page,String country) {
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   book WHERE b_country = ? \r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";

		List<BookVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;

		firstCnt = (page - 1) * 9 + 1;
		lastCnt = (page * 9);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, country);
			psmt.setInt(2, firstCnt);
			psmt.setInt(3, lastCnt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setbId(rs.getInt("b_id"));
				vo.setbName(rs.getString("b_name"));
				vo.setbWriter(rs.getString("b_writer"));
				vo.setbContent(rs.getString("b_content"));
				vo.setbRegister(rs.getDate("b_register"));
				vo.setbCompany(rs.getString("b_company"));
				vo.setbPrice(rs.getInt("b_price"));
				vo.setbImage(rs.getString("b_image"));
				vo.setbCountry(rs.getString("b_country"));

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

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
