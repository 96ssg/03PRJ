package co.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.DbCommand;
import co.yedam.member.service.MemberService;
import co.yedam.member.serviceImpl.MemberServiceImpl;
import co.yedam.member.vo.MemberVO;

public class MemberJoin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(); // 세션객체에 서버가 가지고 있는 세션객체를 담는다

		// TODO 이곳에 회원가입 처리를 작성한다.
		String id = request.getParameter("uId");
		String pass = request.getParameter("uPassword");
		String name = request.getParameter("uName");
		String tel = request.getParameter("uTel");
		String addr = request.getParameter("uAddress");
		String birth = request.getParameter("uBirth");

		MemberVO member = new MemberVO();
		member.setuId(id);
		member.setuPassword(pass);
		member.setuName(name);
		member.setuTel(Integer.parseInt(tel));
		member.setuAddress(addr);
		member.setuBirth(birth);

		MemberService service = new MemberServiceImpl();
		service.insertMember(member);

		session.setAttribute("id", id);
		request.setAttribute("member", member);

		return "main/main.tiles";
	}

}
