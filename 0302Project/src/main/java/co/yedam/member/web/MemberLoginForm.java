package co.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;

public class MemberLoginForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 폼 호출
		return "member/memberLoginForm.tiles";
	}

}
