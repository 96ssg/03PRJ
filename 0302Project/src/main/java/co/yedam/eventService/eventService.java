package co.yedam.eventService;

import java.util.List;

import co.yedam.EventVO.EventVO;

public interface eventService {
	
	List<EventVO>eventSelectList();
	EventVO eventSelect(EventVO vo);
	int insertevent(EventVO vo);
	int updateevent(EventVO vo);
	int deleteevent(EventVO vo);

}
