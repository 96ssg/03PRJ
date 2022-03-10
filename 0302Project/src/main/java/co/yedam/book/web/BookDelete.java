package co.yedam.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.serviceImpl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DbCommand;

public class BookDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		// TODO Auto-generated method stub

		String id = request.getParameter("bId");

		BookVO vo = new BookVO();
		vo.setbId(Integer.parseInt(id));

		BookService service = new BookServiceImpl();
		service.deleteBook(vo);

		return "bookList.do";
	}

}
