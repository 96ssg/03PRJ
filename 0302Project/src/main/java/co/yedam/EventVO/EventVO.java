package co.yedam.EventVO;

public class EventVO {

	private int eventId;
	private int eNumber;
	private String eTitle;
	private String eContent;
	private String eDate;
	private int eventHit;

	public int geteNumber() {
		return eNumber;

	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eContent) {
		this.eContent = eContent;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public int getEventHit() {
		return eventHit;
	}

	public void setEventHit(int eventHit) {
		this.eventHit = eventHit;
	}

	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
}