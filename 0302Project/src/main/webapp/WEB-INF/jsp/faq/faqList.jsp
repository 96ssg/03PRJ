<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
<!--
tr.row:hover {
	background-color: lightyellow;
}
-->
</style>

<script type="text/javascript">
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>

<div>
	<br />
</div>
<div align="center">
	<div>
		<h1>FAQ 목록</h1>
	</div>
	<form id="frm" name="frm" action="faq.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">내용</th>
				<th width="100">작성일자</th>
			</tr>
			<c:forEach var="vo" items="${faq }">
				<tr onclick="formSubmit(${vo.id})">
					<td align="center">${vo.id }</td>
					<td align="center">${vo.title }</td>
					<td align="center">${vo.content }</td>
					<td align="center">${vo.wdate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		&nbsp;&nbsp;&nbsp;
		<c:if test="${id eq 'admin' }">
			<button type="button" onClick="location.href='faqForm.do'">등록</button>
		</c:if>
			
			<td><input type="text" class="form-control" placeholder="검색어 입력를 입력해주세요." name="searchText" maxlength="100">		
			<button type="submit" class="btn btn-success" onClick="location.href='faqSearch.do'">검색</button></td>
		
	</div>
 --%>