package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

// 스프링 컨테이너 환경을 불러오는 기능
@SpringBootTest
public class BoardRepositoryTest {
	
	// 컨테이너 안에 있는 리파지토리 빈 주입
	@Autowired
	BoardRepository repository ;
		
	@Test	// 단위 테스트
	 void 리파지토리빈_확인() {
		System.out.println(100);
	}
	
	@Test
	void 게시물등록() {
		
		Board board1 = Board.builder()
												.title("1번글")
												.content("내용입니다")
												.writer("둘리")
												.build();
		
		Board board2 = Board.builder()
												.title("2번글")
												.content("2내용입니다")
												.writer("또치")
												.build();
		
		Board board3 = Board.builder()
												.title("3번글")
												.content("3내용입니다")
												.writer("도우너")
												.build();
		
		// tbl_board 테이블에 데이터 등록하기
		repository.save(board1);
		repository.save(board2);
		repository.save(board3);
	}
	
	
	
	
}
