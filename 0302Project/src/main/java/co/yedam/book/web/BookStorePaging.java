package co.yedam.book.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.serviceImpl.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.DbCommand;
import co.yedam.common.Paging;

public class BookStorePaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		
		page = page == null ? "1" : page;
		int pageCnt = Integer.parseInt(page);

		BookServiceImpl service = new BookServiceImpl();
		List<BookVO> listTotal = service.bookSelectList();

		service = new BookServiceImpl();
		List<BookVO> list = service.selectBookListPaging(pageCnt);
		
		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(9);
		paging.setTotalCount(listTotal.size());

		request.setAttribute("books", list);
		request.setAttribute("paging", paging);

		return "book/bookStorePaging.tiles";
	}

}
