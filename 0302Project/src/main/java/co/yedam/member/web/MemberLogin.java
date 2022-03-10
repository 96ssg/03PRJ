package co.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.DbCommand;
import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberLogin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 처리 과정
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();  //세션객체에 서버가 가지고 있는 세션객체를 담는다
		
		vo.setuId(request.getParameter("uId"));
		vo.setuPassword(request.getParameter("uPassword"));
		vo = dao.loginCheck(vo);
		String viewPage;
		if(vo.getuName() != null) {
			session.setAttribute("id", vo.getuId());  //세션에 id란 변수로 멤버아이디를 저장
			session.setAttribute("member", vo);
			viewPage = "member/memberLoginSuccess.tiles";
		} else {
			viewPage = "member/memberLoginFail.tiles";
		}
		return viewPage;
	}

}
