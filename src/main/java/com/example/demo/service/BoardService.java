package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {
	
		// 게시물 등록 메소드
		int register(BoardDTO dto);
		
		// 게시물 목록조회 메소드
		// 페이지 번호를 받아서 특정 페이지의 정보를 반환
		Page<BoardDTO> getList(int pageNumber);
		
		// 게시물 상세조회 메소드
		BoardDTO read(int no);
		
		// 게시물 수정 메소드
		void modify(BoardDTO dto);
		
		// 게시물 삭제 메소드
		void remove(int no);
		
		
		
		// default 키워드: 
		default Board dtoToEntity(BoardDTO dto) {
			
			Board entity = Board.builder()
													.no(dto.getNo())
													.title(dto.getTitle())
													.content(dto.getContent())
													.writer(dto.getWriter())
													.build();
			return entity;

		}
		
		// entity -> DTO 변환 메소드
		default BoardDTO entityToDto(Board entity) {
			
			BoardDTO dto = BoardDTO.builder()
														.no(entity.getNo())
														.title(entity.getTitle())
														.content(entity.getContent())
														.writer(entity.getWriter())
														.regDate(entity.getRegDate())
														.modDate(entity.getModDate())
														.build();
			return dto;
		}
			
}
