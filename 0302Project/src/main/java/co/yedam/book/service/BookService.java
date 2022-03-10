package co.yedam.book.service;

import java.util.List;

import co.yedam.book.vo.BookVO;


public interface BookService {
	List<BookVO> bookSelectList();
	BookVO bookSelect(BookVO vo);
	int insertBook(BookVO vo);
	int updateBook(BookVO vo);
	int deleteBook(BookVO vo);
}
