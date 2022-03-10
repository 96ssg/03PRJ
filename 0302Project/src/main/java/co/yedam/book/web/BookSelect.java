package co.yedam.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.serviceImpl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DbCommand;

public class BookSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 책 상세정보 조회
		String id = request.getParameter("bId");
		System.out.println("cont: " + id);

		BookVO vo = new BookVO();
		vo.setbId(Integer.parseInt(id));

		BookService service = new BookServiceImpl();
		vo = service.bookSelect(vo);

		request.setAttribute("vo", vo);

		return "book/bookSelect.tiles";
	}

}
