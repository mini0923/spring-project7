package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@SpringBootTest
public class QuizRepositoryTest {

		
	@Autowired
	BoardRepository repository ;
	
		@Test
		void 게시물목록조회() {
			List<Board> list = repository.findAll();
			System.out.println("게시물목록조회 : ");
			for(Board board : list) {
				System.out.println(board);
			}
			
		}
		
		@Test
		void 게시물단건조회() {
			repository.findById(1);
		}
		
		@Test
		void 게시물수정() {
			
			// 1번 게시물이 존재하는지 확인
			Optional<Board> result = repository.findById(1);
		
			Board board = result.get();
			
			// 일부 내용 수정
			board.setTitle("수정되었습니다.");
			
			// 데이터 업데이트
			repository.save(board);
		}
		
		@Test
		void 게시물삭제() {
			repository.deleteAll();
		}
	
}
