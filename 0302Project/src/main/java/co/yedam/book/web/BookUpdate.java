package co.yedam.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.serviceImpl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DbCommand;

public class BookUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String price = request.getParameter("bPrice");
		String id = request.getParameter("bId2");
		System.out.println("id:"+id);
		BookVO vo = new BookVO();
		vo.setbPrice(Integer.parseInt(price));
		vo.setbId(Integer.parseInt(id));

		BookService service = new BookServiceImpl();
		service.updateBook(vo);

	

		return "bookList.do";
	}

}
