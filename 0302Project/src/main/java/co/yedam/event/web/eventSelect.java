package co.yedam.event.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.EventVO.EventVO;
import co.yedam.common.DbCommand;
import co.yedam.eventServiceImpl.eventServiceImpl;

public class eventSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("cont: " + id);

		EventVO vo = new EventVO();
		vo.setEventId(Integer.parseInt(request.getParameter("id")));

		eventServiceImpl service = new eventServiceImpl();
		vo = service.eventSelect(vo);

		request.setAttribute("event", vo);

		return "event/event.tiles";
	}

}
