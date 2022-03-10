<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
	<div>
		<br />
	</div>
	<form id="frm" name="frm" method="post">
	<div align="center">
		<div>
			<h1>도서 목록</h1>
			<input type="text" id="bId" name="bId" placeholder="도서ID">
			<button type="submit" formaction="bookDelete.do">책삭제</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input type="text" id="bId" name="bId2" placeholder="도서ID">
			<input type="text" id="bPrice" name="bPrice" placeholder="수정할가격">
			<button type="submit" formaction="bookUpdate.do">책 가격수정</button>
		</div>
		<div>
			<table class="table">
				<tr>
					<th width="100">도서번호</th>
					<th width="100">도서명</th>
					<th width="100">저자</th>
					<th width="100">내용요약</th>
					<th width="100">등록날짜</th>
					<th width="100">회사</th>
					<th width="100">가격</th>
					<th width="100">국가분류</th>

				</tr>
				<c:forEach var="vo" items="${book }">
					<tr>
						<td align="center">${vo.bId }</td>
						<td align="center">${vo.bName }</td>
						<td align="center">${vo.bWriter }</td>
						<td align="center">${vo.bContent }</td>
						<td align="center">${vo.bRegister }</td>
						<td align="center">${vo.bCompany }</td>
						<td align="center">${vo.bPrice }</td>
						<td align="center">${vo.bCountry }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br />
		<div>
			<button type="button" onClick="location.href='bookStorePaging.do'">STORE</button>
			&nbsp;&nbsp;&nbsp;
		</div>
	</div>
		</form>