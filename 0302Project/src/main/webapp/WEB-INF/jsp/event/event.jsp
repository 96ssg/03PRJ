<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
	<form id="id" name="id" action="eventUpdate.do" method="post">
		<input type="hidden" id="id" name="id" value="${event.eventId }">
		

		
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%; ">글 제목</td>
						<td colspan="2"><textarea name="title" rows="1" cols="110" >${event.eTitle }</textarea></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${event.eventId }</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">${event.eDate }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: center;"><textarea name="content" rows="6" cols="110">${event.eContent}</textarea></td>
					</tr>
				</tbody>
			</table>
			<button type="button" onclick="location.href='eventList.do'"  class="btn btn-primary">목록보기</button>
			<button type="submit" onclick="return confirm('정말로 수정하시겠습니까?')"  class="btn btn-primary">수정하기</button>
			<button type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')" formaction="eventDelete.do?id=${event.eventId }" class="btn btn-primary">삭제</button>
	</form>
	</div>
	</div>