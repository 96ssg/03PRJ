package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.web.Book;
import co.yedam.book.web.BookDelete;
import co.yedam.book.web.BookForm;
import co.yedam.book.web.BookInsert;
import co.yedam.book.web.BookInsertForm;
import co.yedam.book.web.BookList;
import co.yedam.book.web.BookSelect;
import co.yedam.book.web.BookStore;
import co.yedam.book.web.BookStorePaging;
import co.yedam.book.web.BookUpdate;
import co.yedam.member.web.MemberJoin;
import co.yedam.member.web.MemberJoinForm;
import co.yedam.member.web.MemberLogin;
import co.yedam.member.web.MemberLoginForm;
import co.yedam.member.web.MemberLoginOut;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new MainPage()); // 시작페이지
		
		//로그인 관련
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 처리
		map.put("/memberLoginOut.do", new MemberLoginOut()); // 로그아웃 처리
//		map.put("/idCheck.do",new IdCheck());  //아이디 중복 체크
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입 처리

		//book store 관련
		map.put("/book.do", new Book());
		map.put("/bookList.do", new BookList()); // 책전체조회
		map.put("/bookStorePaging.do", new BookStorePaging());
		map.put("/bookForm.do", new BookForm());
		map.put("/bookStore.do", new BookStore()); // 북스토어 폼 호출
		map.put("/bookInsert.do", new BookInsert()); //책 등록
		map.put("/bookInsertForm.do", new BookInsertForm()); //책 등록
		map.put("/bookSelect.do", new BookSelect()); //책 단건조회
		map.put("/bookUpdate.do", new BookUpdate()); //책 수정
		map.put("/bookDelete.do", new BookDelete()); //책 삭제
		
		
		
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
