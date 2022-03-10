package co.yedam.book.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.serviceImpl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DbCommand;

public class BookList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BookService service = new BookServiceImpl();
		List<BookVO> list = service.bookSelectList();
		
		request.setAttribute("book", list);
		
		return "book/bookList.tiles";
	}

}
