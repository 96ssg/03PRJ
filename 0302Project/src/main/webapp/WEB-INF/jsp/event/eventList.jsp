<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>
</head>

<body>
<div class="container">
<div class="row">
<div align="center">

<div>
	<br />
</div>
	<div>
		<h2>이벤트</h2>
	</div>
	<div>
	<br />
</div>
<form id="frm" name="frm" action="eventSelect.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
<thead>
<tr>
<th style="background-color: #eeeeee; text-align: center;">번호</th>
<th style="background-color: #eeeeee; text-align: center;">제목</th>
<th style="background-color: #eeeeee; text-align: center;">내용</th>
<th style="background-color: #eeeeee; text-align: center;">작성일</th>
</tr>

<c:forEach var="vo" items="${list }">
				<tr onclick="formSubmit(${vo.eventId})">
					<td align="center">${vo.eventId }</td>
					<td align="center">${vo.eTitle }</td>
					<td align="center">${vo.eContent }</td>
					<td align="center">${vo.eDate }</td>
				</tr>
			</c:forEach>
</thead>
<tbody>


</tbody>
</table>

<div>
	<br />
</div>
<a href="eventForm.do" class="btn btn-primary pull-right">글쓰기</a>
<div>
	<br />
</div>
<div>
	<br />
</div>
</div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>