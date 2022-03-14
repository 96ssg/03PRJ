package co.yedam.event.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.EventVO.EventVO;
import co.yedam.common.DbCommand;
import co.yedam.eventService.eventService;
import co.yedam.eventServiceImpl.eventServiceImpl;

public class eventUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		EventVO vo = new EventVO();
		vo.seteTitle(title);;
		vo.seteContent(content);;
		vo.setEventId(Integer.parseInt(id));

		eventService service = new eventServiceImpl();
		service.updateevent(vo);

		service = new eventServiceImpl();
		List<EventVO> list = service.eventSelectList();

		request.setAttribute("list", list);

		return "event/eventList.tiles";
	}

}
