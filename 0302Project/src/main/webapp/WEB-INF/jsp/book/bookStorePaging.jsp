<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function goPage(page) {
		location.href = "bookStorePaging.do?page=" + page ;
	}
 	function selectB(id){
 		location.href = "bookSelect.do"
 	}
</script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- Start Content -->
<div class="container py-5">
	<div class="row">

		<div class="col-lg-3">
			<h1 class="h2 pb-4">Filter-By</h1>
			<ul class="list-unstyled templatemo-accordion">
				<li class="pb-3"><a
					class="collapsed d-flex justify-content-between h3 text-decoration-none"
					href="bookStore.do?country=국내"> Best <i class="fa fa-fw fa-chevron-circle-down mt-1"></i>
				</a>
					<ul class="collapse show list-unstyled pl-3">
						<li><a class="text-decoration-none" href="bookStore.do?country=국내">국내</a></li>
						<li><a class="text-decoration-none" href="bookStore.do?country=해외">해외</a></li>
					</ul></li>
				<li class="pb-3"><a
					class="collapsed d-flex justify-content-between h3 text-decoration-none"
					href="#"> New <i
						class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
				</a>
					<ul id="collapseTwo" class="collapse list-unstyled pl-3">
						<li><a class="text-decoration-none" href="#">국내</a></li>
						<li><a class="text-decoration-none" href="#">해외</a></li>
					</ul></li>

			</ul>
		</div>
		<div class="col-lg-9">
			<c:if test="${id eq 'admin'}">
				<div class="dropdown">
					<button class="dropbtn">
						<span class="dropbtn_icon"></span>관리자 도서관리 메뉴
					</button>
					<div class="dropdown-content">
						<a href="bookList.do">책 조회/삭제/수정</a> <a href="bookInsertForm.do">책
							등록</a>
					</div>
				</div>
			</c:if>
			<div class="row">
				<c:forEach var="vo" items="${books}">
					<div class="col-md-4">
						<div class="card mb-4 product-wap rounded-0">
							<div class="card rounded-0">
								<img class="card-img rounded-0 img-fluid" src="imageFile/${vo.bImage }"
									height="200px">
								<div
									class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
									<ul class="list-unstyled">
										<li><a class="btn btn-success text-white mt-2"
											href="bookSelect.do"><i class="fas fa-cart-plus"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body">
								<a href="bookSelect.do?bId=${vo.bId }" class="h3 text-decoration-none">${vo.bName} </a>
								<ul
									class="w-100 list-unstyled d-flex justify-content-between mb-0">

									<li class="pt-2"><span
										class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
										<span
										class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
										<span
										class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
										<span
										class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
										<span
										class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
									</li>
								</ul>
								<p class="text-center mb-0">${vo.bPrice}원</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
				<div class="col-lg-12">

			<div class="pagination pagination-lg justify-content-center">
				<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a> 
				<a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a> 
				<span>
					<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
						<c:choose>
							<c:when test="${i eq paging.pageNo}">
								<a href="javascript:goPage(${i})" class="choice">${i}</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:goPage(${i})">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</span> <a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a> 
				<a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
			</div>
		</div>

	</div>

</div>

<!-- End Content -->