package co.yedam.faq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.faq.service.faqService;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class faqSearch implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		faqService service = new faqServiceImpl();
		String title = request.getParameter("title");
		List<faqVO> list = service.noticeSearch(title);
		
		request.setAttribute("list", list);
		
		return "faq/faqSearch.tiles";

	}

}
