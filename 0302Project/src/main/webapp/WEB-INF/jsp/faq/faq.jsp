<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div>
	<h1>공지사항 내용</h1>
</div>
<div>

	<form action="bulletinUpdate.do" method="post">
		<input type="hidden" id="uid" value="${id }"> <input
			type="hidden" name="writer" id="writer"
			value="${bulletin.bbsWriter }"> <input type="hidden"
			name="id" value="${bulletin.bbsId }">
		<table border="1">
			<tr>
				<th>제목:</th>
				<td><input type="text" name="title" id="title"
					value="${bulletin.bbsTitle }"></td>
			</tr>
			<tr>
				<th>내용:</th>
				<td width="1000">
					
					<textarea name="content" id="content" cols="60" rows="20">${bulletin.bbsContent }</textarea>
					
					<div>${vo.content }</div> 
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					 <input type="submit"
					value="수정"> 
					<button type="button" id="delBtn">삭제</button>
					<button type="button" onclick="location.href='bulletinList.do'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</div>