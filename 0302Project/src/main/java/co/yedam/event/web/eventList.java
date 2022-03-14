package co.yedam.event.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.EventVO.EventVO;
import co.yedam.common.DbCommand;
import co.yedam.eventService.eventService;
import co.yedam.eventServiceImpl.eventServiceImpl;

public class eventList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		eventService service = new eventServiceImpl();
		List<EventVO> list = service.eventSelectList();

		request.setAttribute("list", list); // evetList.do -> eventList.jsp

		return "event/eventList.tiles";
	}

}
