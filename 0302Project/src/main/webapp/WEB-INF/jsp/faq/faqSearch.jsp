<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>


<div align="center">
	<div>
		<h1>FAQ 목록</h1>
	</div>
	<form id="frm" name="frm" action="faq.do" method="post">
		<input type="hidden" id="id" name="id">


		<div>
			<table class="table">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="100">내용</th>
					<th width="100">작성일자</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr onclick="formSubmit(${vo.id})">
						<td align="center">${vo.id }</td>
						<td align="center">${vo.title }</td>
						<td align="center">${vo.content }</td>
						<td align="center">${vo.wdate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		&nbsp;&nbsp;&nbsp;
		<c:if test="${id eq 'admin' }">
			<button type="button" onClick="location.href='faqForm.do'">등록</button>
		</c:if>
		<form action="faqSearch.do">
			<input type="text" class="search" size="40" required="required"
				placeholder="검색어 입력를 입력해주세요." id="title" name="title"
				maxlength="100">
			<button type="submit" class="btn btn-success">검색</button>
		</form>
	</div>
</div>
</body>
</html>