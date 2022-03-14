package co.yedam.faq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.faq.service.faqService;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class faqUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		faqVO vo = new faqVO();
		vo.setTitle(title);
		vo.setContent(content);
		
		faqService service = new faqServiceImpl();
		service.updateNotice(vo);
		/*
		 * System.out.println(title); System.out.println(content);
		 */		
		service = new faqServiceImpl();
		List<faqVO> list = service.noticeSelectList();
		
		request.setAttribute("list", list);
		System.out.println(list);
		
		return "faq/faqUpdate.tiles";
		
	}

}
