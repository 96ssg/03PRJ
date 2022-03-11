package co.yedam.cart.service;

import java.util.List;

import co.yedam.cart.vo.CartVO;

public interface CartService {
	//카트 내역 삭제
	public int deleteCart(CartVO vo);
	//카트 내역 추가
	public int insertCart(CartVO vo);
	//카트 내역 수정
	public int updateCart(CartVO vo);
	//카트 리스트
	CartVO selectCart(CartVO vo);
	//전체 조회
	List<CartVO> selectCartList();
}
