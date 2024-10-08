package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@SpringBootTest
public class BoardServiceTest {
		
		@Autowired
		BoardService service ;
		
		@Test
		public void 빈이주입되었는지확인() {
				System.out.println("service : " + service);
		}
	
		@Test
		public void 게시물등록() {
			BoardDTO dto = BoardDTO.builder()
																	.title("1번글")
																	.content("내용입니다")
																	.writer("둘리")
																	.build();
			
			int no = service.register(dto);
			
			System.out.println("새로운 게시물 번호 : " + no);
		}
		
		@Test
		public void 게시물수정() {
			
			// 1번 게시물 조회
			BoardDTO dto = service.read(1);
			
			// 일부 내용 변경
			dto.setContent("수정");
			
			// 변경한 내용 업데이트
			service.modify(dto);
			                                                    
			
			
		}
		
		@Test
		public void 첫번째페이지_게시물목록조회() {
			
			// 첫번째 페이지 조회
			Page<BoardDTO> page =  service.getList(1);	// 0 또는 1
			
			// 게시물 목록만 출력
			List<BoardDTO> list = page.getContent();
			
			for (BoardDTO dto : list) {
				System.out.println(dto);
			}
		}
		
}
