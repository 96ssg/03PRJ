<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    
<!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">
                    <div class="card mb-3">
                        <img class="ssg" src="imageFile/${vo.bImage }" alt="Card image cap" id="product-detail" height="512.58px">
                    </div>
                    
                </div>
                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="h2">${vo.bName }</h1>
                            <p class="h3 py-2">${vo.bPrice}원</p>
                            <p class="py-2">
                                
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Company:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>${vo.bCompany}</strong></p>
                                </li>
                            </ul>

                            <h6>내용요약</h6>
                            <p>${vo.bContent }</p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>Country</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>${vo.bCountry }</strong></p>
                                </li>
                            </ul>

                            <h6></h6>
                            <ul class="list-unstyled pb-3">
                                
                            </ul>

                            
                                <input type="hidden" name="product-title" value="Activewear">
                                <div class="row">
                                 
                                    <div class="col-auto">
                                        <ul class="list-inline pb-3">
                                            <li class="list-inline-item text-right">
                                                Quantity
                                                <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                            </li>
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                            <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                            <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="row pb-3">
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" formaction="#">Buy</button>
                                    </div>
                                    <div class="col d-grid">
                                        <button type="submit" class="btn btn-success btn-lg" formaction="#">Add To Cart</button>
                                    </div>
                                </div>
                            

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Close Content -->

   