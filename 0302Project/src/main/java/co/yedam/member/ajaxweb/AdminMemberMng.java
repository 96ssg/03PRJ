package co.yedam.member.ajaxweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;

public class AdminMemberMng implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "member/adminMamberMng.tiles";
	}
}
