<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-latest.js"></script> 

<div align="center">
<div>
<h3>책등록</h3>
</div>
<div>
		<form id="frm" name="frm" action="bookInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="150">도서번호</th>
						<td width="300"><input type="text" id="bId" name="bId"></td>
					</tr>
					<tr>
						<th width="150">도서명</th>
						<td width="300"><input type="text" id="bName" name="bName"></td>
					</tr>
					<tr>
						<th width="150">저자</th>
						<td width="300"><input type="text" id="bWriter" name="bWriter"></td>
					</tr>
					<tr>
						<th width="150">내용요약</th>
						<td width="300"><input type="text" id="bContent" name="bContent"></td>
					</tr>
					<tr>
						<th width="150">회사</th>
						<td width="300"><input type="text" id="bCompany" name="bCompany"></td>
					</tr>
					<tr>
						<th width="150">가격</th>
						<td width="300"><input type="text" id="bPrice" name="bPrice"></td>
					</tr>
					<tr>
						<th width="150">국가</th>
						<td width="300"><input type="text" id="bCountry" name="bCountry"></td>
					</tr>
					<tr>
						<th width="150">이미지</th>
						<td width="300"><input type="file" id="bImage" name="bImage"></td>
					</tr>
				</table>
			</div><br />
			<div>
				<button type="submit">책등록</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
	</div>