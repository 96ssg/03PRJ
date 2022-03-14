package co.yedam.event.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.EventVO.EventVO;
import co.yedam.common.DbCommand;
import co.yedam.eventService.eventService;
import co.yedam.eventServiceImpl.eventServiceImpl;

public class eventInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		EventVO vo = new EventVO();
		vo.seteContent(content);
		vo.seteTitle(title);

		
		eventService service = new eventServiceImpl();
		service.insertevent(vo);
		
		

		return "eventList.do";
	}

}
