package com.ib.cat.board.service;

import java.util.List;

import javax.activation.CommandMap;

import org.springframework.web.multipart.MultipartFile;

import com.ib.cat.board.model.BoardVo;

public interface BoardService {
	
		//전체 회원 목록 조희
		public abstract List<BoardVo> list();
		
		//정보 입력
		public abstract void boardinsert(BoardVo boardVo);
		
		//정보삭제
		public abstract void delete(int no);
		
		//정보수정
		public abstract void update(BoardVo boardVo);
		
		//상세조회
		public abstract int detail(BoardVo boardVo);

		//목록중 하나만조회
		public abstract BoardVo selectById(int no);
		
		//조회수 카운트
		public abstract int updateReadCount(int no);

}
