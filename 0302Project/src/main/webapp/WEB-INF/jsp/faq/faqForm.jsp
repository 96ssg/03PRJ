<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="center">
	<div><h1>FAQ 등록하기</h1></div>	
	<div>
		<form id="frm" name="frm" action="faqWrite.do" method="post">
			<div>
			<table border="1">
				<tr>
					<th width="70">제목</th>
					<td width="200"><input type="text" id="title" name="title" size="50"></td>	 
				<tr>
					<th width="70">내용</th>
					<td colspan="3">
						<textarea id="content" name="content" rows="6" cols="90"></textarea>
					</td>
					</tr>
				
			</table>
			</div> <br/>
			<div>
				<input type="submit" value="저장하기" >&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소" >&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록가기" onclick="location.href='faqListPaging.do'">
				<!-- 아직 지정 x -->
				<input type="button" value="수정하기">
			</div>
		</form>	
	</div>
</div>